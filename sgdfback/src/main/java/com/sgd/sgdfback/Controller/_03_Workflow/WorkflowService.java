package com.sgd.sgdfback.Controller._03_Workflow;

import com.sgd.sgdfback.Models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class WorkflowService {

    @Autowired
    private WorkflowRepository workflowRepository;

    public List<Map<String, Object>> inicioFlujo(User user, InicioRequest request) {
        String flujo = request.getFlujo();
        String formulario = request.getFormulario();
        String comentario = "";

        String carrera = workflowRepository.getUnidadIdByUserId(user.getId());

        // Crear nuevo trámite y obtener su ID
        workflowRepository.createTramite(flujo, formulario, user.getId(), carrera);

        // Obtener el ID del trámite insertado
        String nroTramite = workflowRepository.getLastTramiteIdByUserId(user.getId());

        // Obtener el id del rol de usuario
        Map<String, Object> roleData = workflowRepository.getRoleDataByUserId(user.getId());
        Integer rolId = (Integer) roleData.get("id");
        String unidadId = (String) roleData.get("unidad_id");

        // Obtener tiempo del proceso
        Integer tiempo = workflowRepository.getTiempoByFlujoAndProceso(flujo, "P1");

        // Obtener la fecha y hora actual y sumar el tiempo del proceso
        LocalDateTime fechaHoraFutura = LocalDateTime.now().plusHours(tiempo);

        workflowRepository.crearSeguimiento(nroTramite, flujo, "P1", rolId, comentario, unidadId, user.getId(),
                fechaHoraFutura);
        

        return workflowRepository.datos_tramite_hr(nroTramite);
    }

    public String siguienteFormulario(User user, SiguienteFormRequest request) {
        String flujo = request.getFlujo();
        String proceso = request.getProceso();
        String tramiteId = request.getTramiteId();
        String comentario = request.getComentario();
        String condicion = request.getCondicion();

        String procesoSiguiente = workflowRepository.getProcesoSigByFlujoAndProceso(flujo, proceso);

        if (procesoSiguiente == null) {
            procesoSiguiente = workflowRepository.getProcesoByCondicion(flujo, proceso, condicion);
        }

        Integer procesoObservado = workflowRepository.getProcesoObservadoCount(flujo, procesoSiguiente, tramiteId);

        if (procesoObservado > 0) {
            workflowRepository.updateSeguimientoEstadoObservado(flujo, procesoSiguiente, tramiteId);
        }

        workflowRepository.updateSeguimientoFechaFin(flujo, proceso, tramiteId);

        workflowRepository.updateTramiteProceso(flujo, procesoSiguiente, tramiteId);

        Map<String, Object> roleData = workflowRepository.getRoleDataByFlujoAndProceso(flujo, procesoSiguiente);
        Integer rolId = (Integer) roleData.get("role_id");

        String carrera;
        Integer siguienteUserId;

        if (rolId.equals(1) || rolId.equals(2) || rolId.equals(13) || rolId.equals(14)) {
            Map<String, Object> userRole = workflowRepository.getUserRoleByRoleId(rolId);
            siguienteUserId = (Integer) userRole.get("user_id");
            carrera = (String) userRole.get("unidad_id");
        } else if (rolId.equals(7)) {
            Map<String, Object> tramite = workflowRepository.getTramiteById(tramiteId);
            siguienteUserId = (Integer) tramite.get("user_id");
            carrera = (String) tramite.get("carrera");
        } else {
            carrera = workflowRepository.getCarreraByTramiteId(tramiteId);
            siguienteUserId = workflowRepository.getUserIdByRoleIdAndCarrera(rolId, carrera); // ARREGLAR PARA ASIGNACION DE DOCENTES INTERINOS
        }

        Integer tiempo = workflowRepository.getTiempoByFlujoAndProceso(flujo, procesoSiguiente);

        LocalDateTime fechaHoraFutura = LocalDateTime.now().plusHours(tiempo);

        String[] partes = procesoSiguiente.split("-");
        if (partes.length > 1) {
            String x = partes[0] + "-" + partes[1];
            workflowRepository.crearSeguimientoFin(tramiteId, flujo, x, rolId, comentario, carrera, siguienteUserId,
                    fechaHoraFutura);

            workflowRepository.updateTramiteEstadoTerminado(tramiteId, flujo);

            return "Finalizado";
        } else {
            workflowRepository.crearSeguimiento(tramiteId, flujo, procesoSiguiente, rolId, comentario, carrera,
                    siguienteUserId, fechaHoraFutura);
            return "Siguiente Proceso";
        }
    }
}
