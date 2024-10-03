package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.Convalidacion01DAO;
import com.sgd.sgdfback.model.Convalidacion01;
import com.sgd.sgdfback.service.Convalidacion01Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class Convalidacion01ServiceImpl implements Convalidacion01Service {

    private final Convalidacion01DAO convalidacion01Repository;

    public Convalidacion01ServiceImpl(Convalidacion01DAO convalidacion01dao){
        this.convalidacion01Repository = convalidacion01dao;
    }

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        Convalidacion01 convalidacion01 = convalidacion01Repository.findByTramiteId(nroTramite);
        if (convalidacion01 != null) {
            try {
                Field field = Convalidacion01.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(convalidacion01, param);
                convalidacion01Repository.save(convalidacion01);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convalidación con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        Convalidacion01 convalidacion01 = convalidacion01Repository.findByTramiteId(nroTramite);
        if (convalidacion01 != null) {
            try {
                Field field = Convalidacion01.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(convalidacion01);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convalidación con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public Convalidacion01 crearConvalidacion(Convalidacion01 convalidacion01) {
        return convalidacion01Repository.save(convalidacion01);
    }

    @Override
    public Optional<Convalidacion01> obtenerConvalidacionPorId(Integer id) {
        return convalidacion01Repository.findById(id);
    }

    @Override
    public List<Convalidacion01> obtenerTodasLasConvalidaciones() {
        return convalidacion01Repository.findAll();
    }

    @Override
    public Convalidacion01 actualizarConvalidacion(Integer id, Convalidacion01 convalidacion01) {
        if (convalidacion01Repository.existsById(id)) {
            convalidacion01.setId(id);
            return convalidacion01Repository.save(convalidacion01);
        }
        return null;
    }

    @Override
    public void eliminarConvalidacion(Integer id) {
        if (convalidacion01Repository.existsById(id)) {
            convalidacion01Repository.deleteById(id);
        } else {
            throw new RuntimeException("La convalidación con ID " + id + " no existe.");
        }
    }
}
