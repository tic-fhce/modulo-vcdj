package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.SeguimientoDAO;

@Service
public class SeguimientoService {

    private final SeguimientoDAO seguimientoRepository;

    public SeguimientoService(SeguimientoDAO seguimientoRepository) {
        this.seguimientoRepository = seguimientoRepository;
    }
    

    public List<Map<String, Object>> listarSeguimientos() {
        return seguimientoRepository.findAllSeguimientos();
    }

    public List<Map<String, Object>> listarTramitesPendientes(Integer userId) {
        Optional<Map<String, Object>> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Map<String, Object> resultMap = roleAndUnidad.get();
        Integer rolId = (Integer) resultMap.get("rolId");
        String unidadId = (String) resultMap.get("unidadId");
        return seguimientoRepository.findPendientesByUserRoleAndCarrera(rolId, unidadId, userId);
    }

    public List<Map<String, Object>> listarTramitesConcluidos(Integer userId) {
        Optional<Map<String, Object>> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Map<String, Object> resultMap = roleAndUnidad.get();
        Integer rolId = (Integer) resultMap.get("rolId");
        String unidadId = (String) resultMap.get("unidadId");
        return seguimientoRepository.findConcluidosByUserRoleAndCarrera(rolId, unidadId, userId);
    }

    public List<Map<String, Object>> listarHR(Integer userId) {
        Optional<Map<String, Object>> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Map<String, Object> resultMap = roleAndUnidad.get();
        Integer rolId = (Integer) resultMap.get("rolId");
        String unidadId = (String) resultMap.get("unidadId");
        return seguimientoRepository.findHR(rolId, unidadId, userId);
    }

    public Integer countTramitesPend(Integer userId){
        Optional<Map<String, Object>> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Map<String, Object> resultMap = roleAndUnidad.get();
        Integer rolId = (Integer) resultMap.get("rolId");
        String unidadId = (String) resultMap.get("unidadId");
        return seguimientoRepository.countTramitesPendientes(rolId, unidadId, userId);
    }

    public Integer countTramitesConcl(Integer userId){
        Optional<Map<String, Object>> roleAndUnidad = seguimientoRepository.findRoleAndUnidadByUserId(userId);
        Map<String, Object> resultMap = roleAndUnidad.get();
        Integer rolId = (Integer) resultMap.get("rolId");
        String unidadId = (String) resultMap.get("unidadId");
        return seguimientoRepository.countTramitesConcluidos(rolId, unidadId, userId);
    }

    public void activateV(String flujo, String proceso, String nroTramite) {
        seguimientoRepository.activateVisto(flujo, proceso, nroTramite);
    }
}

