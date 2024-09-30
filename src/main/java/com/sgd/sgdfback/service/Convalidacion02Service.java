package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.Convalidacion02;

import java.util.List;
import java.util.Optional;

public interface Convalidacion02Service {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    // Métodos CRUD
    Convalidacion02 crearConvalidacion(Convalidacion02 convalidacion02);
    Optional<Convalidacion02> obtenerConvalidacionPorId(Integer id);
    List<Convalidacion02> obtenerTodasLasConvalidaciones();
    Convalidacion02 actualizarConvalidacion(Integer id, Convalidacion02 convalidacion02);
    void eliminarConvalidacion(Integer id);
}
