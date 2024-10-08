package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.DesignacionTribunalDAO;
import com.sgd.sgdfback.model.DesignacionTribunal;
import com.sgd.sgdfback.service.DesignacionTribunalService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class DesignacionTribunalServiceImpl implements DesignacionTribunalService {

    private final DesignacionTribunalDAO designacionTribunalRepository;

    public DesignacionTribunalServiceImpl(DesignacionTribunalDAO designacionTribunalDAO){
        this.designacionTribunalRepository = designacionTribunalDAO;
    }

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        DesignacionTribunal designacionTribunal = designacionTribunalRepository.findByTramiteId(nroTramite);
        if (designacionTribunal != null) {
            try {
                Field field = DesignacionTribunal.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(designacionTribunal, param);
                designacionTribunalRepository.save(designacionTribunal);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la designación con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        DesignacionTribunal designacionTribunal = designacionTribunalRepository.findByTramiteId(nroTramite);
        if (designacionTribunal != null) {
            try {
                Field field = DesignacionTribunal.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(designacionTribunal);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la designación con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public DesignacionTribunal crearDesignacion(DesignacionTribunal designacionTribunal) {
        return designacionTribunalRepository.save(designacionTribunal);
    }

    @Override
    public Optional<DesignacionTribunal> obtenerDesignacionPorId(Integer id) {
        return designacionTribunalRepository.findById(id);
    }

    @Override
    public List<DesignacionTribunal> obtenerTodasLasDesignaciones() {
        return designacionTribunalRepository.findAll();
    }

    @Override
    public DesignacionTribunal actualizarDesignacion(Integer id, DesignacionTribunal designacionTribunal) {
        if (designacionTribunalRepository.existsById(id)) {
            designacionTribunal.setId(id);
            return designacionTribunalRepository.save(designacionTribunal);
        }
        return null;
    }

    @Override
    public void eliminarDesignacion(Integer id) {
        if (designacionTribunalRepository.existsById(id)) {
            designacionTribunalRepository.deleteById(id);
        } else {
            throw new RuntimeException("La designación con ID " + id + " no existe.");
        }
    }

    @Override
    public List<DesignacionTribunal> obtenerAprobacionPerfilPorUsuario(Integer userId) {
        return designacionTribunalRepository.findByUserId(userId);
    }
}
