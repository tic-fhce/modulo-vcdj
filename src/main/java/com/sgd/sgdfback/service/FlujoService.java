package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.model.Flujo;

@Service
public interface FlujoService {

    List<Flujo> listarFlujosPorRoleIdYProceso(String username, String proceso);

    void actualizarHabilitado(Integer id, String habilitado);

    void actualizarProcedimiento(Integer id, String formulario, Integer rol, Integer tiempo);

    // Métodos CRUD
    Flujo crearFlujo(Flujo flujo);
    Optional<Flujo> obtenerFlujoPorId(Integer id);
    List<Flujo> obtenerTodosLosFlujos();
    Flujo actualizarFlujo(Integer id, Flujo flujo);
    void eliminarFlujo(Integer id);
}
