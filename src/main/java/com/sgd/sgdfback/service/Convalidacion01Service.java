package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.Convalidacion01;

import java.util.List;
import java.util.Optional;

public interface Convalidacion01Service {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    List<Convalidacion01> obtenerConvalidacionCarreraYear(String carrera, Integer year);

    // Métodos CRUD
    Convalidacion01 crearConvalidacion(Convalidacion01 convalidacion01);
    Optional<Convalidacion01> obtenerConvalidacionPorId(Integer id);
    List<Convalidacion01> obtenerTodasLasConvalidaciones();
    Convalidacion01 actualizarConvalidacion(Integer id, Convalidacion01 convalidacion01);
    void eliminarConvalidacion(Integer id);
}
