package com.sgd.sgdfback.Controller._04_Seguimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeguimientoService {

    @Autowired
    private final SeguimientoRepository seguimientoRepository;

    public SeguimientoService(SeguimientoRepository seguimientoRepository) {
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

    public void quitarTramite(String flujo, String proceso, String nroTramite) {
        seguimientoRepository.deactivateTramite(flujo, proceso, nroTramite);
    }
}

