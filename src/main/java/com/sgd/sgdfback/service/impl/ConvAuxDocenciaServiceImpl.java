package com.sgd.sgdfback.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.ConvAuxDocenciaDAO;
import com.sgd.sgdfback.dao.TramiteDAO;
import com.sgd.sgdfback.model.ConvAuxDocencia;
import com.sgd.sgdfback.model.Tramite;
import com.sgd.sgdfback.object.ConvDocInterinosCrearRequest;
import com.sgd.sgdfback.service.ConvAuxDocenciaService;

@Service
public class ConvAuxDocenciaServiceImpl implements ConvAuxDocenciaService {

    private final ConvAuxDocenciaDAO convocatoriaDAO;
    private final TramiteDAO tramiteDAO;

    public ConvAuxDocenciaServiceImpl(ConvAuxDocenciaDAO convocatoriaDAO, TramiteDAO tramiteDAO) {
        this.convocatoriaDAO = convocatoriaDAO;
        this.tramiteDAO = tramiteDAO;
    }

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite, Integer userId) {
        ConvAuxDocencia convocatoria = convocatoriaDAO.findByTramiteId(nroTramite);

        if (convocatoria != null) {
            try {
                Field field = ConvAuxDocencia.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(convocatoria, param);
                convocatoriaDAO.save(convocatoria);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convalidación con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        ConvAuxDocencia convocatoria = convocatoriaDAO.findByTramiteId(nroTramite);
        if (convocatoria != null) {
            try {
                Field field = ConvAuxDocencia.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(convocatoria);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la convocatoria con el trámite especificado");
        }
    }

    @Override
    public ConvAuxDocencia crearConvocatoria(ConvDocInterinosCrearRequest request) {
        try {
            Tramite t = tramiteDAO.findById(request.getNrotramite())
                    .orElseThrow(() -> new RuntimeException("Trámite no encontrado"));
            ConvAuxDocencia cdc = new ConvAuxDocencia();
            cdc.setTramite(t);
            return convocatoriaDAO.save(cdc);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Error: Por favor, verifica el número del trámite.", e);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error de acceso a datos al guardar.", e);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error inesperado al crear.", e);
        }
    }

    @Override
    public Optional<ConvAuxDocencia> obtenerConvocatoriaPorTramite(String nroTramite) {
        return convocatoriaDAO.findByConvocatoriaId(nroTramite);
    }

    // Implementación del CRUD
    @Override
    public ConvAuxDocencia crearConvocatoria(ConvAuxDocencia convocatoria) {
        return convocatoriaDAO.save(convocatoria);
    }

    @Override
    public Optional<ConvAuxDocencia> obtenerConvocatoriaPorId(Integer id) {
        return convocatoriaDAO.findById(id);
    }

    @Override
    public List<ConvAuxDocencia> obtenerTodasLasConvocatorias() {
        return convocatoriaDAO.findAll();
    }

    @Override
    public ConvAuxDocencia actualizarConvocatoria(Integer id, ConvAuxDocencia convocatoria) {
        if (convocatoriaDAO.existsById(id)) {
            convocatoria.setId(id);
            return convocatoriaDAO.save(convocatoria);
        }
        return null;
    }

    @Override
    public void eliminarConvocatoria(Integer id) {
        if (convocatoriaDAO.existsById(id)) {
            convocatoriaDAO.deleteById(id);
        } else {
            throw new RuntimeException("La convocatoria con ID " + id + " no existe.");
        }
    }
}
