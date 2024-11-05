package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.AprobacionPerfil;
import com.sgd.sgdfback.object.AprobacionPerfilCrearRequest;

import java.util.List;
import java.util.Optional;

public interface AprobacionPerfilService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    List<AprobacionPerfil> obtenerAprobacionPerfilsCarreraYear(String carrera, Integer year);
    AprobacionPerfil crearAprobacionPerfilDatos(AprobacionPerfilCrearRequest request);
    Optional<AprobacionPerfil> obtenerAprobacionPorTramite(String nroTramite);

    // Métodos CRUD
    AprobacionPerfil crearAprobacionPerfil(AprobacionPerfil aprobacionPerfil);
    Optional<AprobacionPerfil> obtenerAprobacionPerfilPorId(Integer id);
    List<AprobacionPerfil> obtenerTodosLosAprobacionPerfil();
    AprobacionPerfil actualizarAprobacionPerfil(Integer id, AprobacionPerfil aprobacionPerfil);
    void eliminarAprobacionPerfil(Integer id);
}
