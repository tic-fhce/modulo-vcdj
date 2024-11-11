package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Optional;

import com.sgd.sgdfback.model.ConvDocContratados;
import com.sgd.sgdfback.object.ConvDocInterinosCrearRequest;

public interface ConvDocContratadosService {
    void actualizarColumna(String columna, String param, String nroTramite, Integer userId);
    String obtenerColumna(String nroTramite, String columna);
    ConvDocContratados crearConvocatoria(ConvDocInterinosCrearRequest request);
    Optional<ConvDocContratados> obtenerConvocatoriaPorTramite(String nroTramite);

    // Métodos CRUD
    ConvDocContratados crearConvocatoria(ConvDocContratados convocatoria);
    Optional<ConvDocContratados> obtenerConvocatoriaPorId(Integer id);
    List<ConvDocContratados> obtenerTodasLasConvocatorias();
    ConvDocContratados actualizarConvocatoria(Integer id, ConvDocContratados convocatoria);
    void eliminarConvocatoria(Integer id);
}
