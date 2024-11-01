package com.sgd.sgdfback.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.FlujoDAO;
import com.sgd.sgdfback.dao.SeguimientoDAO;
import com.sgd.sgdfback.dao.TramiteDAO;
import com.sgd.sgdfback.dao.UsuarioRolDAO;
import com.sgd.sgdfback.dao.WorkflowDAO;
import com.sgd.sgdfback.model.Flujo;
import com.sgd.sgdfback.model.Seguimiento;
import com.sgd.sgdfback.model.Tramite;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.model.UsuarioRol;
import com.sgd.sgdfback.object.WorkflowInicioRequest;
import com.sgd.sgdfback.object.WorkflowSiguienteFormRequest;

@Service
public class WorkflowService {

    private WorkflowDAO workflowRepository;
    private TramiteDAO tramiteDAO;
    private SeguimientoDAO seguimientoDAO;
    private FlujoDAO flujoDAO;
    private UsuarioRolDAO usuarioRolDAO;

    public WorkflowService(WorkflowDAO workflowRepository, TramiteDAO tramiteDAO, SeguimientoDAO seguimientoDAO,
            FlujoDAO flujoDAO, UsuarioRolDAO usuarioRolDAO) {
        this.workflowRepository = workflowRepository;
        this.tramiteDAO = tramiteDAO;
        this.seguimientoDAO = seguimientoDAO;
        this.flujoDAO = flujoDAO;
        this.usuarioRolDAO = usuarioRolDAO;
    }

    public List<Map<String, Object>> inicioFlujo(Usuario user, WorkflowInicioRequest request) {
        String nroTramite = null;
        try {
            String flujo = request.getFlujo();
            String tipo = request.getFormulario();
            String carrera = user.getUser_roles().get(0).getUnidad().getId();

            workflowRepository.createTramite(flujo, tipo, user.getId(), carrera);
            nroTramite = workflowRepository.getLastTramiteIdByUserId(user.getId());
            if (nroTramite == null) {
                throw new RuntimeException("No se pudo obtener el ID del trámite insertado.");
            }

            Tramite t = tramiteDAO.findById(nroTramite)
                    .orElseThrow(() -> new RuntimeException("Trámite no encontrado"));
            Flujo f = flujoDAO.findFlujoByFlujoAndProceso(flujo, "P1")
                    .orElseThrow(() -> new RuntimeException("Flujo no encontrado"));
            UsuarioRol ur = usuarioRolDAO.findById(user.getUser_roles().get(0).getId())
                    .orElseThrow(() -> new RuntimeException("UsuarioRol no encontrado"));

            Integer tiempo = f.getTiempo();
            if (tiempo == null) {
                throw new RuntimeException("No se pudo obtener el tiempo");
            }
            LocalDateTime fechaHoraFutura = LocalDateTime.now().plusHours(tiempo);

            Seguimiento seg = new Seguimiento();
            seg.setTramite(t);
            seg.setFlujo(f);
            seg.setUsuarioRol(ur);
            seg.setFecha_inicio(LocalDateTime.now());
            seg.setEstado("pendiente");
            seg.setTiempo(fechaHoraFutura);
            seguimientoDAO.save(seg);

            return tramiteDAO.findDatosHojaRuta(nroTramite);
        } catch (RuntimeException e) {
            System.err.println("Error en inicioFlujo: " + e.getMessage());
            throw new RuntimeException("Ocurrió un error al iniciar el flujo. " + e.getMessage(), e);

        } catch (Exception e) {
            System.err.println("Error inesperado en inicioFlujo: " + e.getMessage());
            throw new RuntimeException("Error inesperado en inicioFlujo. Por favor, inténtelo de nuevo más tarde.", e);
        }
    }

    @Transactional
    public String siguienteFormulario(Usuario user, WorkflowSiguienteFormRequest request) {
        try {
            String flujo = request.getFlujo();
            String proceso = request.getProceso();
            String tramiteId = request.getTramiteId();
            String comentario = request.getComentario();
            String condicion = request.getCondicion();

            Flujo f1 = flujoDAO.findFlujoByFlujoAndProceso(flujo, proceso).orElseThrow(() -> new RuntimeException("Flujo no encontrado para el proceso actual"));

            String procesoSiguiente = f1.getProceso_sig();
            if (procesoSiguiente == null) {
                if (condicion.equals("si")) {
                    procesoSiguiente = f1.getProcesoCondicion().getSi();
                } else {
                    procesoSiguiente = f1.getProcesoCondicion().getNo();
                }
            }

            Seguimiento s1 = seguimientoDAO.findByTramiteId(tramiteId, flujo, proceso).orElseThrow(() -> new RuntimeException("Seguimiento no encontrado para el trámite y proceso especificado"));
            s1.setFecha_fin(LocalDateTime.now());
            s1.setEstado("terminado");
            seguimientoDAO.save(s1);

            Flujo f2 = flujoDAO.findFlujoByFlujoAndProceso(flujo, procesoSiguiente).orElseThrow(() -> new RuntimeException("Flujo no encontrado para el siguiente proceso"));

            Integer countObs = seguimientoDAO.findObservadoCount(tramiteId, f2.getId());
            if (countObs > 0) {
                seguimientoDAO.updateEstadoObservado(tramiteId, f2.getId());
            }

            Integer tiempo = f2.getTiempo();
            LocalDateTime fechaHoraFutura = LocalDateTime.now().plusHours(tiempo);
            Integer SigRolId = f2.getRole().getId();
            String unidadId = user.getUser_roles().get(0).getUnidad().getId();

            Tramite t1 = tramiteDAO.findById(tramiteId).orElseThrow(() -> new RuntimeException("Trámite no encontrado para el ID especificado"));
            t1.setProceso(procesoSiguiente);

            UsuarioRol ur = null;
            try {
                if (SigRolId.equals(1) || SigRolId.equals(2) || SigRolId.equals(13) || SigRolId.equals(14)) {
                    ur = usuarioRolDAO.findRolUnidad(SigRolId, "FHCE").orElseThrow(() -> new RuntimeException("Usuario con rol y unidad no encontrado en FHCE"));
                } else if (SigRolId.equals(6) || SigRolId.equals(7)) {
                    ur = usuarioRolDAO.findUsuarioRolUnidad(SigRolId, unidadId, t1.getUser_id()).orElseThrow(() -> new RuntimeException("Usuario con rol y unidad específicos no encontrado"));
                } else {
                    ur = usuarioRolDAO.findRolUnidad(SigRolId, unidadId).orElseThrow(() -> new RuntimeException("Usuario con rol y unidad específicos no encontrado"));
                }
            } catch (Exception e) {
                throw new RuntimeException("Error al asignar UsuarioRol: " + e.getMessage());
            }

            LocalDateTime fechaFin = null;
            if (procesoSiguiente.endsWith("Fin")) {
                fechaFin = LocalDateTime.now();
                t1.setEstado("terminado");
            }
            tramiteDAO.save(t1);

            Seguimiento seg = new Seguimiento();
            seg.setTramite(t1);
            seg.setFlujo(f2);
            seg.setUsuarioRol(ur);
            seg.setFecha_fin(fechaFin);
            seg.setFecha_inicio(LocalDateTime.now());
            seg.setEstado("pendiente");
            seg.setTiempo(fechaHoraFutura);
            seg.setComentario(comentario);
            seguimientoDAO.save(seg);

            return "Proceso Siguiente";

        } catch (Exception e) {
            throw new RuntimeException("Error en siguienteFormulario: " + e.getMessage(), e);
        }
    }

}
