package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.MateriaExtraDAO;
import com.sgd.sgdfback.model.MateriaExtra;
import com.sgd.sgdfback.service.MateriaExtraService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaExtraServiceImpl implements MateriaExtraService {

    private final MateriaExtraDAO materiaExtraRepository;

    public MateriaExtraServiceImpl(MateriaExtraDAO materiaExtraDAO){
        this.materiaExtraRepository = materiaExtraDAO;
    }

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        MateriaExtra materiaExtra = materiaExtraRepository.findByTramiteId(nroTramite);
        if (materiaExtra != null) {
            try {
                Field field = MateriaExtra.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(materiaExtra, param);
                materiaExtraRepository.save(materiaExtra);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la materia extra con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        MateriaExtra materiaExtra = materiaExtraRepository.findByTramiteId(nroTramite);
        if (materiaExtra != null) {
            try {
                Field field = MateriaExtra.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(materiaExtra);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la materia extra con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public MateriaExtra crearMateriaExtra(MateriaExtra materiaExtra) {
        return materiaExtraRepository.save(materiaExtra);
    }

    @Override
    public Optional<MateriaExtra> obtenerMateriaExtraPorId(Integer id) {
        return materiaExtraRepository.findById(id);
    }

    @Override
    public List<MateriaExtra> obtenerTodasLasMateriasExtras() {
        return materiaExtraRepository.findAll();
    }

    @Override
    public MateriaExtra actualizarMateriaExtra(Integer id, MateriaExtra materiaExtra) {
        if (materiaExtraRepository.existsById(id)) {
            materiaExtra.setId(id);
            return materiaExtraRepository.save(materiaExtra);
        }
        return null;
    }

    @Override
    public void eliminarMateriaExtra(Integer id) {
        if (materiaExtraRepository.existsById(id)) {
            materiaExtraRepository.deleteById(id);
        } else {
            throw new RuntimeException("La materia extra con ID " + id + " no existe.");
        }
    }
}
