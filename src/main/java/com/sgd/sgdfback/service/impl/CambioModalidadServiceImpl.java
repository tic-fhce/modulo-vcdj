package com.sgd.sgdfback.service.impl;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.CambioModalidadDAO;
import com.sgd.sgdfback.model.CambioModalidad;
import com.sgd.sgdfback.service.CambioModalidadService;

import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CambioModalidadServiceImpl implements CambioModalidadService {

    private final CambioModalidadDAO cambioModalidadRepository;

    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        CambioModalidad cambioModalidad = cambioModalidadRepository.findByTramiteId(nroTramite);
        if (cambioModalidad != null) {
            try {
                Field field = CambioModalidad.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(cambioModalidad, param);
                cambioModalidadRepository.save(cambioModalidad);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró el cambio de modalidad con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        CambioModalidad cambioModalidad = cambioModalidadRepository.findByTramiteId(nroTramite);
        if (cambioModalidad != null) {
            try {
                Field field = CambioModalidad.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(cambioModalidad);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró el cambio de modalidad con el trámite especificado");
        }
    }

    @Override
    public Map<String, Object> obtenerTodoPorTramiteId(String nroTramite) {
        CambioModalidad cambioModalidad = cambioModalidadRepository.findByTramiteId(nroTramite);
        if (cambioModalidad != null) {
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("aprobacion_perfil_id", cambioModalidad.getAprobacion_Perfil().getId());
            resultado.put("user_id", cambioModalidad.getUser_id());
            resultado.put("cambio", cambioModalidad.getCambio());
            resultado.put("n_modalidad", cambioModalidad.getN_modalidad());
            resultado.put("n_titulo", cambioModalidad.getN_titulo());
            resultado.put("n_tutor", cambioModalidad.getN_tutor());
            return resultado;
        } else {
            throw new RuntimeException("No se encontró el cambio de modalidad con el trámite especificado");
        }
    }

    // Implementación del CRUD
    @Override
    public CambioModalidad crearCambioModalidad(CambioModalidad cambioModalidad) {
        return cambioModalidadRepository.save(cambioModalidad);
    }

    @Override
    public Optional<CambioModalidad> obtenerCambioModalidadPorId(Integer id) {
        return cambioModalidadRepository.findById(id);
    }

    @Override
    public List<CambioModalidad> obtenerTodosLosCambioModalidad() {
        return cambioModalidadRepository.findAll();
    }

    @Override
    public CambioModalidad actualizarCambioModalidad(Integer id, CambioModalidad cambioModalidad) {
        if (cambioModalidadRepository.existsById(id)) {
            cambioModalidad.setId(id);
            return cambioModalidadRepository.save(cambioModalidad);
        }
        return null;
    }

    @Override
    public void eliminarCambioModalidad(Integer id) {
        if (cambioModalidadRepository.existsById(id)) {
            cambioModalidadRepository.deleteById(id);
        } else {
            throw new RuntimeException("El cambio de modalidad con ID " + id + " no existe.");
        }
    }
}
