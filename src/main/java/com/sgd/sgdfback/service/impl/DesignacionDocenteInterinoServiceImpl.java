package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.DesignacionDocenteInterinoDAO;
import com.sgd.sgdfback.model.DesignacionDocentesInterinos;
import com.sgd.sgdfback.service.DesignacionDocenteInterinoService;

import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DesignacionDocenteInterinoServiceImpl implements DesignacionDocenteInterinoService {

    private final DesignacionDocenteInterinoDAO designacionDocentesInterinosRepository;

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        DesignacionDocentesInterinos designacionDocenteInterino = designacionDocentesInterinosRepository.findByTramiteId(nroTramite);
        if (designacionDocenteInterino != null) {
            try {
                Field field = DesignacionDocentesInterinos.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(designacionDocenteInterino, param);
                designacionDocentesInterinosRepository.save(designacionDocenteInterino);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la designación con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        DesignacionDocentesInterinos designacionDocenteInterino = designacionDocentesInterinosRepository.findByTramiteId(nroTramite);
        if (designacionDocenteInterino != null) {
            try {
                Field field = DesignacionDocentesInterinos.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(designacionDocenteInterino);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la designación con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public DesignacionDocentesInterinos crearDesignacion(DesignacionDocentesInterinos designacionDocenteInterino) {
        return designacionDocentesInterinosRepository.save(designacionDocenteInterino);
    }

    @Override
    public Optional<DesignacionDocentesInterinos> obtenerDesignacionPorId(Integer id) {
        return designacionDocentesInterinosRepository.findById(id);
    }

    @Override
    public List<DesignacionDocentesInterinos> obtenerTodasLasDesignaciones() {
        return designacionDocentesInterinosRepository.findAll();
    }

    @Override
    public DesignacionDocentesInterinos actualizarDesignacion(Integer id, DesignacionDocentesInterinos designacionDocenteInterino) {
        if (designacionDocentesInterinosRepository.existsById(id)) {
            designacionDocenteInterino.setId(id);
            return designacionDocentesInterinosRepository.save(designacionDocenteInterino);
        }
        return null;
    }

    @Override
    public void eliminarDesignacion(Integer id) {
        if (designacionDocentesInterinosRepository.existsById(id)) {
            designacionDocentesInterinosRepository.deleteById(id);
        } else {
            throw new RuntimeException("La designación con ID " + id + " no existe.");
        }
    }
}
