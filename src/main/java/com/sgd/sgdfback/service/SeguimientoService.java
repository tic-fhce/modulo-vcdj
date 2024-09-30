package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.SeguimientoDAO;

@Service
public class SeguimientoService {

    @Autowired
    private final SeguimientoDAO seguimientoRepository;

    public SeguimientoService(SeguimientoDAO seguimientoRepository) {
        this.seguimientoRepository = seguimientoRepository;
    }

    public List<Map<String, Object>> listarSeguimientos() {
        return seguimientoRepository.findAllSeguimientos();
    }

    public List<Map<String, Object>> listarTramitesPendientes(Integer userId) {
        Map<String, Object> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Integer rolId = (Integer) roleAndUnidad.get("id");
        String carrera = (String) roleAndUnidad.get("unidad_id");
        return seguimientoRepository.findPendientesByUserRoleAndCarrera(rolId, carrera, userId);
    }

    public List<Map<String, Object>> listarTramitesConcluidos(Integer userId) {
        Map<String, Object> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Integer rolId = (Integer) roleAndUnidad.get("id");
        String carrera = (String) roleAndUnidad.get("unidad_id");
        return seguimientoRepository.findConcluidosByUserRoleAndCarrera(rolId, carrera, userId);
    }

    public List<Map<String, Object>> listarHR(Integer userId) {
        Map<String, Object> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Integer rolId = (Integer) roleAndUnidad.get("id");
        String carrera = (String) roleAndUnidad.get("unidad_id");
        return seguimientoRepository.findHR(rolId, carrera, userId);
    }

    public Integer countTramitesPend(Integer userId){
        Map<String, Object> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Integer rolId = (Integer) roleAndUnidad.get("id");
        String carrera = (String) roleAndUnidad.get("unidad_id");
        return seguimientoRepository.countTramitesPendientes(rolId, carrera, userId);
    }

    public Integer countTramitesConcl(Integer userId){
        Map<String, Object> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Integer rolId = (Integer) roleAndUnidad.get("id");
        String carrera = (String) roleAndUnidad.get("unidad_id");
        return seguimientoRepository.countTramitesConcluidos(rolId, carrera, userId);
    }

    public void activateV(String flujo, String proceso, String nroTramite) {
        seguimientoRepository.activateVisto(flujo, proceso, nroTramite);
    }
}

