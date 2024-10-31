package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.CertificadoConclusion;

import java.util.List;
import java.util.Optional;

public interface CertificadoConclusionService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    List<CertificadoConclusion> obtenerCertificadosCarreraYear(String carrera, Integer year);

    // Métodos CRUD
    CertificadoConclusion crearCertificadoConclusion(CertificadoConclusion certificadoConclusion);
    Optional<CertificadoConclusion> obtenerCertificadoConclusionPorId(Integer id);
    List<CertificadoConclusion> obtenerTodosLosCertificados();
    CertificadoConclusion actualizarCertificadoConclusion(Integer id, CertificadoConclusion certificadoConclusion);
    void eliminarCertificadoConclusion(Integer id);
}
