package com.sgd.sgdfback.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.FlujoDAO;
import com.sgd.sgdfback.dao.ProcesoCondicionDAO;
import com.sgd.sgdfback.dao.SeguimientoDAO;
import com.sgd.sgdfback.dao.TramiteDAO;
import com.sgd.sgdfback.dao.UsuarioRolDAO;
import com.sgd.sgdfback.dao.WorkflowDAO;
import com.sgd.sgdfback.model.Flujo;
import com.sgd.sgdfback.model.Seguimiento;
import com.sgd.sgdfback.model.Tramite;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.model.UsuarioRol;
import com.sgd.sgdfback.object.WorkflowSiguienteFormRequest;
import com.sgd.sgdfback.object.WorkflowInicioRequest;

@Service
public class WorkflowService {

    private WorkflowDAO workflowRepository;
    private TramiteDAO tramiteDAO;
    private SeguimientoDAO seguimientoDAO;
    private FlujoDAO flujoDAO;
    private ProcesoCondicionDAO procesoCondicionDAO;
    private UsuarioRolDAO usuarioRolDAO;

    public WorkflowService(WorkflowDAO workflowRepository, TramiteDAO tramiteDAO, SeguimientoDAO seguimientoDAO, FlujoDAO flujoDAO, ProcesoCondicionDAO procesoCondicionDAO, UsuarioRolDAO usuarioRolDAO) {
        this.workflowRepository = workflowRepository;
        this.tramiteDAO = tramiteDAO;
        this.seguimientoDAO = seguimientoDAO;
        this.flujoDAO = flujoDAO;
        this.procesoCondicionDAO = procesoCondicionDAO;
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

            Tramite t = tramiteDAO.findById(nroTramite).orElseThrow(() -> new RuntimeException("Trámite no encontrado"));
            Flujo f = flujoDAO.findFlujoByFlujoAndProceso(flujo, "P1").orElseThrow(() -> new RuntimeException("Flujo no encontrado"));
            UsuarioRol ur = usuarioRolDAO.findById(user.getUser_roles().get(0).getId()).orElseThrow(() -> new RuntimeException("UsuarioRol no encontrado"));
    
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
    
    public String siguienteFormulario(Usuario user, WorkflowSiguienteFormRequest request) {
        String flujo = request.getFlujo();
        String proceso = request.getProceso();
        String tramiteId = request.getTramiteId();
        String comentario = request.getComentario();
        String condicion = request.getCondicion();

        Flujo f1 = flujoDAO.findFlujoByFlujoAndProceso(flujo, proceso).orElseThrow(() -> new RuntimeException("Flujo no encontrado"));
        
        String procesoSiguiente = f1.getProceso_sig();
        if (procesoSiguiente == null) {
            if(condicion.equals("si")){
                procesoSiguiente = f1.getProcesoCondicion().getSi();
            } else {
                procesoSiguiente = f1.getProcesoCondicion().getNo();
            }
        }

        /*Integer procesoObservado = workflowRepository.getProcesoObservadoCount(flujo, procesoSiguiente, tramiteId);

        if (procesoObservado > 0) {
            workflowRepository.updateSeguimientoEstadoObservado(flujo, procesoSiguiente, tramiteId);
        }*/


        Seguimiento s1 = seguimientoDAO.findByTramiteId(tramiteId, flujo, proceso).orElseThrow(() -> new RuntimeException("Seguimiento no encontrado"));
        s1.setFecha_fin(LocalDateTime.now());
        s1.setEstado("terminado");
        seguimientoDAO.save(s1);

        Flujo f2 = flujoDAO.findFlujoByFlujoAndProceso(flujo, procesoSiguiente).orElseThrow(() -> new RuntimeException("Flujo no encontrado"));
        
        Integer tiempo = f2.getTiempo();
        LocalDateTime fechaHoraFutura = LocalDateTime.now().plusHours(tiempo);        
        Integer SigRolId = f2.getRole().getId();
        String unidadId = user.getUser_roles().get(0).getUnidad().getId();

        Tramite t1 = tramiteDAO.findById(tramiteId).orElseThrow(() -> new RuntimeException("Tramite no encontrado"));
        t1.setProceso(procesoSiguiente);

        UsuarioRol ur = new UsuarioRol();
        if(SigRolId.equals(1) || SigRolId.equals(2) || SigRolId.equals(13) || SigRolId.equals(14)){
            ur = usuarioRolDAO.findRolUnidad(SigRolId, "FHCE").orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        } else if(SigRolId.equals(6) || SigRolId.equals(7)) {
            ur = usuarioRolDAO.findUsuarioRolUnidad(SigRolId, unidadId, t1.getUser_id()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));            
        } else {
            ur = usuarioRolDAO.findRolUnidad(SigRolId, unidadId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));            
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
    }
}
