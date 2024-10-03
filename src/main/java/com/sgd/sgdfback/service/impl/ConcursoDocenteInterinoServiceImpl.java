package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.ConcursoDocenteInterinoDAO;
import com.sgd.sgdfback.model.ConcursoDocentesInterinos;
import com.sgd.sgdfback.service.ConcursoDocenteInterinoService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class ConcursoDocenteInterinoServiceImpl implements ConcursoDocenteInterinoService {

    private final ConcursoDocenteInterinoDAO concursoDocentesInterinosRepository;

    public ConcursoDocenteInterinoServiceImpl(ConcursoDocenteInterinoDAO concursoDocenteInterinoDAO){
        this.concursoDocentesInterinosRepository = concursoDocenteInterinoDAO;
    }

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        ConcursoDocentesInterinos concursoDocenteInterino = concursoDocentesInterinosRepository.findByTramiteId(nroTramite);
        if (concursoDocenteInterino != null) {
            try {
                Field field = ConcursoDocentesInterinos.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(concursoDocenteInterino, param);
                concursoDocentesInterinosRepository.save(concursoDocenteInterino);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró el concurso docente interino con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        ConcursoDocentesInterinos concursoDocenteInterino = concursoDocentesInterinosRepository.findByTramiteId(nroTramite);
        if (concursoDocenteInterino != null) {
            try {
                Field field = ConcursoDocentesInterinos.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(concursoDocenteInterino);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró el concurso docente interino con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public ConcursoDocentesInterinos crearConcursoDocenteInterino(ConcursoDocentesInterinos concursoDocenteInterino) {
        return concursoDocentesInterinosRepository.save(concursoDocenteInterino);
    }

    @Override
    public Optional<ConcursoDocentesInterinos> obtenerConcursoDocenteInterinoPorId(Integer id) {
        return concursoDocentesInterinosRepository.findById(id);
    }

    @Override
    public List<ConcursoDocentesInterinos> obtenerTodosLosConcursoDocentesInterinos() {
        return concursoDocentesInterinosRepository.findAll();
    }

    @Override
    public ConcursoDocentesInterinos actualizarConcursoDocenteInterino(Integer id, ConcursoDocentesInterinos concursoDocenteInterino) {
        if (concursoDocentesInterinosRepository.existsById(id)) {
            concursoDocenteInterino.setId(id);
            return concursoDocentesInterinosRepository.save(concursoDocenteInterino);
        }
        return null;
    }

    @Override
    public void eliminarConcursoDocenteInterino(Integer id) {
        if (concursoDocentesInterinosRepository.existsById(id)) {
            concursoDocentesInterinosRepository.deleteById(id);
        } else {
            throw new RuntimeException("El concurso docente interino con ID " + id + " no existe.");
        }
    }
}
