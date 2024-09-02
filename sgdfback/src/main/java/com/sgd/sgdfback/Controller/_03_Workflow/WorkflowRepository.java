package com.sgd.sgdfback.Controller._03_Workflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class WorkflowRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> datos_tramite_hr(String id_tramite) {
        String sql = "SELECT t.id, t.tipo, t.creacion, t.proceso, un.nombre AS carrera, f.formulario, t.estado, r.name AS unidad " + //
                        "FROM tramite t " + //
                        "INNER JOIN user u ON t.user_id = u.id " + //
                        "LEFT JOIN flujo f ON t.flujo = f.flujo AND t.proceso = f.proceso " + //
                        "LEFT JOIN seguimiento s ON t.flujo = s.flujo AND t.proceso = s.proceso AND t.id = s.tramite_id " + //
                        "LEFT JOIN role r ON s.role_id = r.id " + //
                        "LEFT JOIN unidad un ON un.id = t.carrera " + //
                        "WHERE t.id = ?";
        return jdbcTemplate.queryForList(sql, id_tramite);
    }

    public String getUnidadIdByUserId(Integer userId) {
        String query = "SELECT unidad_id FROM user_role WHERE user_id = ?";
        return jdbcTemplate.queryForObject(query, String.class, userId);
    }

    public void createTramite(String flujo, String formulario, Integer userId, String carrera) {
        String query = "INSERT INTO tramite (flujo, tipo, user_id, carrera, proceso, estado, creacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, flujo, formulario, userId, carrera, "P1", "pendiente", LocalDateTime.now());
    }

    public String getLastTramiteIdByUserId(Integer userId) {
        String query = "SELECT id FROM tramite WHERE user_id = ? ORDER BY creacion DESC LIMIT 1";
        return jdbcTemplate.queryForObject(query, String.class, userId);
    }

    public Map<String, Object> getRoleDataByUserId(Integer userId) {
        String query = "SELECT r.id, ur.unidad_id FROM user_role ur JOIN role r ON ur.role_id = r.id WHERE ur.user_id = ?";
        return jdbcTemplate.queryForMap(query, userId);
    }

    public Integer getTiempoByFlujoAndProceso(String flujo, String proceso) {
        String query = "SELECT tiempo FROM flujo WHERE flujo = ? AND proceso = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, flujo, proceso);
    }

    public void crearSeguimiento(String tramite, String flujo, String proceso, Integer rolId, String comentario,
                                 String carrera, Integer userId, LocalDateTime tiempo) {
        String query = "INSERT INTO seguimiento (flujo, proceso, tramite_id, role_id, fecha_inicio, estado, comentario, carrera, user_id, tiempo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, flujo, proceso, tramite, rolId, LocalDateTime.now(), "pendiente", comentario, carrera, userId, tiempo);
    }

    public void crearSeguimientoFin(String tramite, String flujo, String proceso, Integer rolId, String comentario,
                                    String carrera, Integer userId, LocalDateTime tiempo) {
        String query = "INSERT INTO seguimiento (flujo, proceso, tramite_id, role_id, fecha_fin, fecha_inicio, estado, comentario, carrera, user_id, tiempo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, flujo, proceso, tramite, rolId, LocalDateTime.now(), LocalDateTime.now(), "terminado", comentario, carrera, userId, tiempo);
    }

    public String getProcesoSigByFlujoAndProceso(String flujo, String proceso) {
        String query = "SELECT proceso_sig FROM flujo WHERE flujo = ? AND proceso = ?";
        return jdbcTemplate.queryForObject(query, String.class, flujo, proceso);
    }

    public String getProcesoByCondicion(String flujo, String proceso, String condicion) {
        String query = "SELECT " + condicion + " FROM procesocond WHERE flujo = ? AND proceso = ?";
        return jdbcTemplate.queryForObject(query, String.class, flujo, proceso);
    }

    public Integer getProcesoObservadoCount(String flujo, String procesoSiguiente, String tramiteId) {
        String query = "SELECT COUNT(*) FROM seguimiento WHERE flujo = ? AND proceso = ? AND tramite_id = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, flujo, procesoSiguiente, tramiteId);
    }

    public void updateSeguimientoEstadoObservado(String flujo, String procesoSiguiente, String tramiteId) {
        String query = "UPDATE seguimiento SET estado = 'observado' WHERE flujo = ? AND proceso = ? AND tramite_id = ?";
        jdbcTemplate.update(query, flujo, procesoSiguiente, tramiteId);
    }

    public void updateSeguimientoFechaFin(String flujo, String proceso, String tramiteId) {
        String query = "UPDATE seguimiento SET fecha_fin = ?, estado = 'terminado' WHERE flujo = ? AND proceso = ? AND tramite_id = ? AND fecha_fin IS NULL";
        jdbcTemplate.update(query, LocalDateTime.now(), flujo, proceso, tramiteId);
    }

    public void updateTramiteProceso(String flujo, String procesoSiguiente, String tramiteId) {
        String query = "UPDATE tramite SET proceso = ? WHERE flujo = ? AND id = ?";
        jdbcTemplate.update(query, procesoSiguiente, flujo, tramiteId);
    }

    public Map<String, Object> getRoleDataByFlujoAndProceso(String flujo, String procesoSiguiente) {
        String query = "SELECT role_id FROM flujo WHERE flujo = ? AND proceso = ?";
        return jdbcTemplate.queryForMap(query, flujo, procesoSiguiente);
    }

    public Map<String, Object> getUserRoleByRoleId(Integer rolId) {
        String query = "SELECT user_id, unidad_id FROM user_role WHERE role_id = ? LIMIT 1";
        return jdbcTemplate.queryForMap(query, rolId);
    }

    public Map<String, Object> getTramiteById(String tramiteId) {
        String query = "SELECT user_id, carrera FROM tramite WHERE id = ?";
        return jdbcTemplate.queryForMap(query, tramiteId);
    }

    public String getCarreraByTramiteId(String tramiteId) {
        String query = "SELECT carrera FROM tramite WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, tramiteId);
    }

    public Integer getUserIdByRoleIdAndCarrera(Integer rolId, String carrera) {
        String query = "SELECT user_id FROM user_role WHERE role_id = ? AND unidad_id = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, rolId, carrera);
    }

    public void updateTramiteEstadoTerminado(String tramiteId, String flujo) {
        String query = "UPDATE tramite SET estado = 'terminado' WHERE id = ? AND flujo = ?";
        jdbcTemplate.update(query, tramiteId, flujo);
    }
}

