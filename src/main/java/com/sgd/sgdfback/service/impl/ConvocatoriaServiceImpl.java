package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.ConvocatoriaDAO;
import com.sgd.sgdfback.model.Convocatoria;
import com.sgd.sgdfback.model.Tramite;
import com.sgd.sgdfback.service.ConvocatoriaService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService {

    private final ConvocatoriaDAO convocatoriaRepository;

    public ConvocatoriaServiceImpl(ConvocatoriaDAO convocatoriaDAO){
        this.convocatoriaRepository = convocatoriaDAO;
    }

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite, Integer userId) {
        Convocatoria convocatoria = convocatoriaRepository.findByTramiteId(nroTramite);

        if (convocatoria != null) {
            try {
                Field field = Convocatoria.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(convocatoria, param);
                convocatoriaRepository.save(convocatoria);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            // Si no existe la convocatoria, crea una nueva
            Tramite t = new Tramite();
            t.setId(nroTramite);


            Convocatoria nuevaConvocatoria = new Convocatoria();
            nuevaConvocatoria.setTramite(new Tramite(nroTramite)); // Ajustar según cómo se gestione la relación con "Tramite"
            nuevaConvocatoria.setUser_id(userId);
            try {
                Field field = Convocatoria.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(nuevaConvocatoria, param);
                convocatoriaRepository.save(nuevaConvocatoria);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error creando la convocatoria con la columna: " + columna, e);
            }
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        Convocatoria convocatoria = convocatoriaRepository.findByTramiteId(nroTramite);
        if (convocatoria != null) {
            try {
                Field field = Convocatoria.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(convocatoria);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convocatoria con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public Convocatoria crearConvocatoria(Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    @Override
    public Optional<Convocatoria> obtenerConvocatoriaPorId(Integer id) {
        return convocatoriaRepository.findById(id);
    }

    @Override
    public List<Convocatoria> obtenerTodasLasConvocatorias() {
        return convocatoriaRepository.findAll();
    }

    @Override
    public Convocatoria actualizarConvocatoria(Integer id, Convocatoria convocatoria) {
        if (convocatoriaRepository.existsById(id)) {
            convocatoria.setId(id);
            return convocatoriaRepository.save(convocatoria);
        }
        return null;
    }

    @Override
    public void eliminarConvocatoria(Integer id) {
        if (convocatoriaRepository.existsById(id)) {
            convocatoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("La convocatoria con ID " + id + " no existe.");
        }
    }
}
