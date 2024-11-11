package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.ConvDocInterinos;
import com.sgd.sgdfback.object.ConvDocInterinosCrearRequest;

import java.util.List;
import java.util.Optional;

public interface ConvDocInterinosService {
    void actualizarColumna(String columna, String param, String nroTramite, Integer userId);
    String obtenerColumna(String nroTramite, String columna);
    ConvDocInterinos crearConvocatoria(ConvDocInterinosCrearRequest request);
    Optional<ConvDocInterinos> obtenerConvocatoriaPorTramite(String nroTramite);

    // Métodos CRUD
    ConvDocInterinos crearConvocatoria(ConvDocInterinos convocatoria);
    Optional<ConvDocInterinos> obtenerConvocatoriaPorId(Integer id);
    List<ConvDocInterinos> obtenerTodasLasConvocatorias();
    ConvDocInterinos actualizarConvocatoria(Integer id, ConvDocInterinos convocatoria);
    void eliminarConvocatoria(Integer id);
}
