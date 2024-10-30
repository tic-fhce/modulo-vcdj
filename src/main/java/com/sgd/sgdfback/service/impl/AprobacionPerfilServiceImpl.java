package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.AprobacionPerfilDAO;
import com.sgd.sgdfback.model.AprobacionPerfil;
import com.sgd.sgdfback.service.AprobacionPerfilService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class AprobacionPerfilServiceImpl implements AprobacionPerfilService {

    private final AprobacionPerfilDAO aprobacionPerfilRepository;

    public AprobacionPerfilServiceImpl(AprobacionPerfilDAO aprobacionPerfilDAO){
        this.aprobacionPerfilRepository = aprobacionPerfilDAO;
    }

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        AprobacionPerfil aprobacionPerfil = aprobacionPerfilRepository.findByTramiteId(nroTramite);
        if (aprobacionPerfil != null) {
            try {
                Field field = AprobacionPerfil.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(aprobacionPerfil, param);
                aprobacionPerfilRepository.save(aprobacionPerfil);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la aprobación de perfil con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        AprobacionPerfil aprobacionPerfil = aprobacionPerfilRepository.findByTramiteId(nroTramite);
        if (aprobacionPerfil != null) {
            try {
                Field field = AprobacionPerfil.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(aprobacionPerfil);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la aprobación de perfil con el trámite especificado");
        }
    }

    @Override
    public List<AprobacionPerfil> obtenerAprobacionPerfilsCarreraYear(String carrera, Integer year){
        return aprobacionPerfilRepository.findByCarreraAndYear(carrera, year);
    }





    // Implementación del CRUD
    @Override
    public AprobacionPerfil crearAprobacionPerfil(AprobacionPerfil aprobacionPerfil) {
        return aprobacionPerfilRepository.save(aprobacionPerfil);
    }

    @Override
    public Optional<AprobacionPerfil> obtenerAprobacionPerfilPorId(Integer id) {
        return aprobacionPerfilRepository.findById(id);
    }

    @Override
    @Transactional
    public List<AprobacionPerfil> obtenerTodosLosAprobacionPerfil() {
        return aprobacionPerfilRepository.findAll();
    }

    @Override
    public AprobacionPerfil actualizarAprobacionPerfil(Integer id, AprobacionPerfil aprobacionPerfil) {
        if (aprobacionPerfilRepository.existsById(id)) {
            aprobacionPerfil.setId(id);
            return aprobacionPerfilRepository.save(aprobacionPerfil);
        }
        return null;
    }

    @Override
    public void eliminarAprobacionPerfil(Integer id) {
        if (aprobacionPerfilRepository.existsById(id)) {
            aprobacionPerfilRepository.deleteById(id);
        } else {
            throw new RuntimeException("La aprobación de perfil con ID " + id + " no existe.");
        }
    }
}
