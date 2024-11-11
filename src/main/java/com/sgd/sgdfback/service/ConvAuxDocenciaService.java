package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Optional;

import com.sgd.sgdfback.model.ConvAuxDocencia;
import com.sgd.sgdfback.object.ConvDocInterinosCrearRequest;

public interface ConvAuxDocenciaService {
    void actualizarColumna(String columna, String param, String nroTramite, Integer userId);
    String obtenerColumna(String nroTramite, String columna);
    ConvAuxDocencia crearConvocatoria(ConvDocInterinosCrearRequest request);
    Optional<ConvAuxDocencia> obtenerConvocatoriaPorTramite(String nroTramite);

    // Métodos CRUD
    ConvAuxDocencia crearConvocatoria(ConvAuxDocencia convocatoria);
    Optional<ConvAuxDocencia> obtenerConvocatoriaPorId(Integer id);
    List<ConvAuxDocencia> obtenerTodasLasConvocatorias();
    ConvAuxDocencia actualizarConvocatoria(Integer id, ConvAuxDocencia convocatoria);
    void eliminarConvocatoria(Integer id);
}
