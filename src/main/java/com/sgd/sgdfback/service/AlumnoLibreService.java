package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Optional;

import com.sgd.sgdfback.model.AlumnoLibre;
import com.sgd.sgdfback.object.AlumnoLibreActColRequest;
import com.sgd.sgdfback.object.AlumnoLibreObtColRequest;

public interface AlumnoLibreService {
    void actualizarColumna(AlumnoLibreActColRequest actualizarDTO);
    String obtenerColumna(AlumnoLibreObtColRequest obtenerDTO);

    // Métodos CRUD
    AlumnoLibre crearAlumno(AlumnoLibre alumnoLibre);
    Optional<AlumnoLibre> obtenerAlumnoPorId(Integer id);
    List<AlumnoLibre> obtenerTodosLosAlumnos();
    AlumnoLibre actualizarAlumno(Integer id, AlumnoLibre alumnoLibre);
    void eliminarAlumno(Integer id);
}
