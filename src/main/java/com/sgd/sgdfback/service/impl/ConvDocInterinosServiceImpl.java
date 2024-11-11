package com.sgd.sgdfback.service.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.ConvDocInterinosDAO;
import com.sgd.sgdfback.dao.TramiteDAO;
import com.sgd.sgdfback.model.ConvDocInterinos;
import com.sgd.sgdfback.model.Tramite;
import com.sgd.sgdfback.object.ConvDocInterinosCrearRequest;
import com.sgd.sgdfback.service.ConvDocInterinosService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ConvDocInterinosServiceImpl implements ConvDocInterinosService {

    private final ConvDocInterinosDAO convocatoriaDAO;
    private final TramiteDAO tramiteDAO;

    public ConvDocInterinosServiceImpl(ConvDocInterinosDAO convocatoriaDAO, TramiteDAO tramiteDAO) {
        this.convocatoriaDAO = convocatoriaDAO;
        this.tramiteDAO = tramiteDAO;
    }    

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite, Integer userId) {
        ConvDocInterinos convocatoria = convocatoriaDAO.findByTramiteId(nroTramite);

        if (convocatoria != null) {
            try {
                Field field = ConvDocInterinos.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(convocatoria, param);
                convocatoriaDAO.save(convocatoria);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convalidación con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        ConvDocInterinos convocatoria = convocatoriaDAO.findByTramiteId(nroTramite);
        if (convocatoria != null) {
            try {
                Field field = ConvDocInterinos.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(convocatoria);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convocatoria con el trámite especificado");
        }
    }

    @Override
    public ConvDocInterinos crearConvocatoria(ConvDocInterinosCrearRequest request) {
        try {
            Tramite t = tramiteDAO.findById(request.getNrotramite()).orElseThrow(() -> new RuntimeException("Trámite no encontrado"));
            ConvDocInterinos cdi = new ConvDocInterinos();
            cdi.setTramite(t);
            cdi.setTipo(request.getTipo());
            return convocatoriaDAO.save(cdi);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Error: Por favor, verifica el número del trámite.", e);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error de acceso a datos al guardar.", e);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error inesperado al crear.", e);
        }
    }

    @Override
    public Optional<ConvDocInterinos> obtenerConvocatoriaPorTramite(String nroTramite) {
        return convocatoriaDAO.findByConvocatoriaId(nroTramite);
    }




    // Implementación del CRUD
    @Override
    public ConvDocInterinos crearConvocatoria(ConvDocInterinos convocatoria) {
        return convocatoriaDAO.save(convocatoria);
    }

    @Override
    public Optional<ConvDocInterinos> obtenerConvocatoriaPorId(Integer id) {
        return convocatoriaDAO.findById(id);
    }

    @Override
    public List<ConvDocInterinos> obtenerTodasLasConvocatorias() {
        return convocatoriaDAO.findAll();
    }

    @Override
    public ConvDocInterinos actualizarConvocatoria(Integer id, ConvDocInterinos convocatoria) {
        if (convocatoriaDAO.existsById(id)) {
            convocatoria.setId(id);
            return convocatoriaDAO.save(convocatoria);
        }
        return null;
    }

    @Override
    public void eliminarConvocatoria(Integer id) {
        if (convocatoriaDAO.existsById(id)) {
            convocatoriaDAO.deleteById(id);
        } else {
            throw new RuntimeException("La convocatoria con ID " + id + " no existe.");
        }
    }
}
