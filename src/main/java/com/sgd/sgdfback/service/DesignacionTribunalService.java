package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.DesignacionTribunal;

import java.util.List;
import java.util.Optional;

public interface DesignacionTribunalService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    // Métodos CRUD
    DesignacionTribunal crearDesignacion(DesignacionTribunal designacionTribunal);
    Optional<DesignacionTribunal> obtenerDesignacionPorId(Integer id);
    List<DesignacionTribunal> obtenerTodasLasDesignaciones();
    DesignacionTribunal actualizarDesignacion(Integer id, DesignacionTribunal designacionTribunal);
    void eliminarDesignacion(Integer id);

    // Métodos adicionales
    List<DesignacionTribunal> obtenerAprobacionPerfilPorUsuario(Integer userId);

    List<DesignacionTribunal> obtenerAprobacionPerfilsCarreraYear(String carrera, Integer year);
}
    