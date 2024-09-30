package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.DesignacionDocentesInterinos;

import java.util.List;
import java.util.Optional;

public interface DesignacionDocenteInterinoService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    // Métodos CRUD
    DesignacionDocentesInterinos crearDesignacion(DesignacionDocentesInterinos designacionDocenteInterino);
    Optional<DesignacionDocentesInterinos> obtenerDesignacionPorId(Integer id);
    List<DesignacionDocentesInterinos> obtenerTodasLasDesignaciones();
    DesignacionDocentesInterinos actualizarDesignacion(Integer id, DesignacionDocentesInterinos designacionDocenteInterino);
    void eliminarDesignacion(Integer id);
}
