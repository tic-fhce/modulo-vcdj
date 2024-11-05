package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.AprobacionPerfil;
import com.sgd.sgdfback.model.DesignacionTribunal;
import com.sgd.sgdfback.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface DesignacionTribunalService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    // Métodos adicionales
    DesignacionTribunal crearDesignacionTribunal(Usuario user, String nrotramite);
    Optional<DesignacionTribunal> obtenerDesignacionPorTramite(String nroTramite);

    List<DesignacionTribunal> obtenerAprobacionPerfilPorUsuario(Integer userId);

    List<DesignacionTribunal> obtenerAprobacionPerfilsCarreraYear(String carrera, Integer year);

    // Métodos CRUD
    DesignacionTribunal crearDesignacion(DesignacionTribunal designacionTribunal);
    Optional<DesignacionTribunal> obtenerDesignacionPorId(Integer id);
    List<DesignacionTribunal> obtenerTodasLasDesignaciones();
    DesignacionTribunal actualizarDesignacion(Integer id, DesignacionTribunal designacionTribunal);
    void eliminarDesignacion(Integer id);
}
    