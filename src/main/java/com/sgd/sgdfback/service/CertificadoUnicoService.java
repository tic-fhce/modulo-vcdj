package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.CertificadoUnico;

import java.util.List;
import java.util.Optional;

public interface CertificadoUnicoService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    // Métodos CRUD
    CertificadoUnico crearCertificadoUnico(CertificadoUnico certificadoUnico);
    Optional<CertificadoUnico> obtenerCertificadoUnicoPorId(Integer id);
    List<CertificadoUnico> obtenerTodosLosCertificadosUnicos();
    CertificadoUnico actualizarCertificadoUnico(Integer id, CertificadoUnico certificadoUnico);
    void eliminarCertificadoUnico(Integer id);
}
