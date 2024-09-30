package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.Convocatoria;

import java.util.List;
import java.util.Optional;

public interface ConvocatoriaService {
    void actualizarColumna(String columna, String param, String nroTramite, Integer userId);
    String obtenerColumna(String nroTramite, String columna);

    // Métodos CRUD
    Convocatoria crearConvocatoria(Convocatoria convocatoria);
    Optional<Convocatoria> obtenerConvocatoriaPorId(Integer id);
    List<Convocatoria> obtenerTodasLasConvocatorias();
    Convocatoria actualizarConvocatoria(Integer id, Convocatoria convocatoria);
    void eliminarConvocatoria(Integer id);
}
