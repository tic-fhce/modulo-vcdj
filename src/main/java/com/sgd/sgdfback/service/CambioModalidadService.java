package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.CambioModalidad;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CambioModalidadService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);
    Map<String, Object> obtenerTodoPorTramiteId(String nroTramite);

    // Métodos CRUD
    CambioModalidad crearCambioModalidad(CambioModalidad cambioModalidad);
    Optional<CambioModalidad> obtenerCambioModalidadPorId(Integer id);
    List<CambioModalidad> obtenerTodosLosCambioModalidad();
    CambioModalidad actualizarCambioModalidad(Integer id, CambioModalidad cambioModalidad);
    void eliminarCambioModalidad(Integer id);
}
