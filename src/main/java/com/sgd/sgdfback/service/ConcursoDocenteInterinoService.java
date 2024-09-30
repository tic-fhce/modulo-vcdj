package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.ConcursoDocentesInterinos;

import java.util.List;
import java.util.Optional;

public interface ConcursoDocenteInterinoService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    // Métodos CRUD
    ConcursoDocentesInterinos crearConcursoDocenteInterino(ConcursoDocentesInterinos concursoDocenteInterino);
    Optional<ConcursoDocentesInterinos> obtenerConcursoDocenteInterinoPorId(Integer id);
    List<ConcursoDocentesInterinos> obtenerTodosLosConcursoDocentesInterinos();
    ConcursoDocentesInterinos actualizarConcursoDocenteInterino(Integer id, ConcursoDocentesInterinos concursoDocenteInterino);
    void eliminarConcursoDocenteInterino(Integer id);
}
