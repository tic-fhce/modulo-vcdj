package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.AlumnoLibreDAO;
import com.sgd.sgdfback.model.AlumnoLibre;
import com.sgd.sgdfback.object.AlumnoLibreActColRequest;
import com.sgd.sgdfback.object.AlumnoLibreObtColRequest;
import com.sgd.sgdfback.service.AlumnoLibreService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoLibreServiceImpl implements AlumnoLibreService {
    
    private final AlumnoLibreDAO alumnoRepository;

    public AlumnoLibreServiceImpl(AlumnoLibreDAO alumnoLibreDAO){
        this.alumnoRepository = alumnoLibreDAO;
    }

    @Override
    public void actualizarColumna(AlumnoLibreActColRequest actualizarDTO) {
        AlumnoLibre alumno = alumnoRepository.findByTramiteId(actualizarDTO.getNrotramite());

        if (alumno != null) {
            try {
                Field field = AlumnoLibre.class.getDeclaredField(actualizarDTO.getColum());
                field.setAccessible(true);
                field.set(alumno, actualizarDTO.getParam());
                alumnoRepository.save(alumno);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + actualizarDTO.getColum(), e);
            }
        } else {
            throw new RuntimeException("No se encontró el alumno con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(AlumnoLibreObtColRequest obtenerDTO) {
        AlumnoLibre alumno = alumnoRepository.findByTramiteId(obtenerDTO.getNrotramite());
        if (alumno != null) {
            try {
                Field field = AlumnoLibre.class.getDeclaredField(obtenerDTO.getColumna());
                field.setAccessible(true);
                return (String) field.get(alumno);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + obtenerDTO.getColumna(), e);
            }
        } else {
            throw new RuntimeException("No se encontró el alumno con el trámite especificado");
        }
    }


    // Implementación del CRUD
    @Override
    public AlumnoLibre crearAlumno(AlumnoLibre alumnoLibre) {
        return alumnoRepository.save(alumnoLibre);
    }

    @Override
    public Optional<AlumnoLibre> obtenerAlumnoPorId(Integer id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public List<AlumnoLibre> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public AlumnoLibre actualizarAlumno(Integer id, AlumnoLibre alumnoLibre) {
        if (alumnoRepository.existsById(id)) {
            alumnoLibre.setId(id);
            return alumnoRepository.save(alumnoLibre);
        }
        return null;
    }

    @Override
    public void eliminarAlumno(Integer id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
        } else {
            throw new RuntimeException("El alumno con ID " + id + " no existe.");
        }
    }
}
