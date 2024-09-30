package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.Convalidacion02DAO;
import com.sgd.sgdfback.model.Convalidacion02;
import com.sgd.sgdfback.service.Convalidacion02Service;

import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class Convalidacion02ServiceImpl implements Convalidacion02Service {

    private final Convalidacion02DAO convalidacion02Repository;

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        Convalidacion02 convalidacion02 = convalidacion02Repository.findByTramiteId(nroTramite);
        if (convalidacion02 != null) {
            try {
                Field field = Convalidacion02.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(convalidacion02, param);
                convalidacion02Repository.save(convalidacion02);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convalidación con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        Convalidacion02 convalidacion02 = convalidacion02Repository.findByTramiteId(nroTramite);
        if (convalidacion02 != null) {
            try {
                Field field = Convalidacion02.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(convalidacion02);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convalidación con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public Convalidacion02 crearConvalidacion(Convalidacion02 convalidacion02) {
        return convalidacion02Repository.save(convalidacion02);
    }

    @Override
    public Optional<Convalidacion02> obtenerConvalidacionPorId(Integer id) {
        return convalidacion02Repository.findById(id);
    }

    @Override
    public List<Convalidacion02> obtenerTodasLasConvalidaciones() {
        return convalidacion02Repository.findAll();
    }

    @Override
    public Convalidacion02 actualizarConvalidacion(Integer id, Convalidacion02 convalidacion02) {
        if (convalidacion02Repository.existsById(id)) {
            convalidacion02.setId(id);
            return convalidacion02Repository.save(convalidacion02);
        }
        return null;
    }

    @Override
    public void eliminarConvalidacion(Integer id) {
        if (convalidacion02Repository.existsById(id)) {
            convalidacion02Repository.deleteById(id);
        } else {
            throw new RuntimeException("La convalidación con ID " + id + " no existe.");
        }
    }
}
