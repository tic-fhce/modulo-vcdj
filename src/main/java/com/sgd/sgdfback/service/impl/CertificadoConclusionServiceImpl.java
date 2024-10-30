package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.CertificadoConclusionDAO;
import com.sgd.sgdfback.model.CertificadoConclusion;
import com.sgd.sgdfback.service.CertificadoConclusionService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class CertificadoConclusionServiceImpl implements CertificadoConclusionService {

    private final CertificadoConclusionDAO certificadoRepository;

    public CertificadoConclusionServiceImpl(CertificadoConclusionDAO certificadoConclusionDAO){
        this.certificadoRepository = certificadoConclusionDAO;
    }

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        CertificadoConclusion certificado = certificadoRepository.findByTramiteId(nroTramite);
        if (certificado != null) {
            try {
                Field field = CertificadoConclusion.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(certificado, param);
                certificadoRepository.save(certificado);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró el certificado de conclusión con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        CertificadoConclusion certificado = certificadoRepository.findByTramiteId(nroTramite);
        if (certificado != null) {
            try {
                Field field = CertificadoConclusion.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(certificado);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró el certificado de conclusión con el trámite especificado");
        }
    }

    @Override
    public List<CertificadoConclusion> obtenerCertificadosCarreraYear(String carrera, Integer year){
        return certificadoRepository.findByCarreraAndYear(carrera, year);
    }

    // Implementación del CRUD
    @Override
    public CertificadoConclusion crearCertificadoConclusion(CertificadoConclusion certificadoConclusion) {
        return certificadoRepository.save(certificadoConclusion);
    }

    @Override
    public Optional<CertificadoConclusion> obtenerCertificadoConclusionPorId(Integer id) {
        return certificadoRepository.findById(id);
    }

    @Override
    public List<CertificadoConclusion> obtenerTodosLosCertificados() {
        return certificadoRepository.findAll();
    }

    @Override
    public CertificadoConclusion actualizarCertificadoConclusion(Integer id, CertificadoConclusion certificadoConclusion) {
        if (certificadoRepository.existsById(id)) {
            certificadoConclusion.setId(id);
            return certificadoRepository.save(certificadoConclusion);
        }
        return null;
    }

    @Override
    public void eliminarCertificadoConclusion(Integer id) {
        if (certificadoRepository.existsById(id)) {
            certificadoRepository.deleteById(id);
        } else {
            throw new RuntimeException("El certificado de conclusión con ID " + id + " no existe.");
        }
    }
}
