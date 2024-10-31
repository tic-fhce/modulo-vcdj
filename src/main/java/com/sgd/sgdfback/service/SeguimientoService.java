package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.model.Seguimiento;
import com.sgd.sgdfback.model.Usuario;

@Service
public interface SeguimientoService {
    List<Map<String, Object>> listarSeguimientos();
    List<Map<String, Object>> listarTramitesPendientes(Usuario user);
    List<Map<String, Object>> listarTramitesConcluidos(Usuario user);
    List<Map<String, Object>> listarHR(Usuario user);
    Integer countTramitesPend(Usuario user);
    Integer countTramitesConcl(Usuario user);
    void activateV(Integer id);


    // CRUD
    Seguimiento crearSeguimiento(Seguimiento seguimiento);
    Optional<Seguimiento> obtenerSeguimientoPorId(Integer id);
    List<Seguimiento> obtenerTodosLosSeguimientos();
    Seguimiento actualizarFlujo(Integer id, Seguimiento seguimiento);
    void eliminarSeguimiento(Integer id);
    
}