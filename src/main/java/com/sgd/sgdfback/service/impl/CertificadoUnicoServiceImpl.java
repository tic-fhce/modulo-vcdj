package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.CertificadoUnicoDAO;
import com.sgd.sgdfback.model.CertificadoUnico;
import com.sgd.sgdfback.service.CertificadoUnicoService;

import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CertificadoUnicoServiceImpl implements CertificadoUnicoService {

    private final CertificadoUnicoDAO certificadoUnicoRepository;

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        CertificadoUnico certificadoUnico = certificadoUnicoRepository.findByTramiteId(nroTramite);
        if (certificadoUnico != null) {
            try {
                Field field = CertificadoUnico.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(certificadoUnico, param);
                certificadoUnicoRepository.save(certificadoUnico);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró el certificado único con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        CertificadoUnico certificadoUnico = certificadoUnicoRepository.findByTramiteId(nroTramite);
        if (certificadoUnico != null) {
            try {
                Field field = CertificadoUnico.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(certificadoUnico);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró el certificado único con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public CertificadoUnico crearCertificadoUnico(CertificadoUnico certificadoUnico) {
        return certificadoUnicoRepository.save(certificadoUnico);
    }

    @Override
    public Optional<CertificadoUnico> obtenerCertificadoUnicoPorId(Integer id) {
        return certificadoUnicoRepository.findById(id);
    }

    @Override
    public List<CertificadoUnico> obtenerTodosLosCertificadosUnicos() {
        return certificadoUnicoRepository.findAll();
    }

    @Override
    public CertificadoUnico actualizarCertificadoUnico(Integer id, CertificadoUnico certificadoUnico) {
        if (certificadoUnicoRepository.existsById(id)) {
            certificadoUnico.setId(id);
            return certificadoUnicoRepository.save(certificadoUnico);
        }
        return null;
    }

    @Override
    public void eliminarCertificadoUnico(Integer id) {
        if (certificadoUnicoRepository.existsById(id)) {
            certificadoUnicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("El certificado único con ID " + id + " no existe.");
        }
    }
}
