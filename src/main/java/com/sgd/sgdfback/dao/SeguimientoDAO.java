package com.sgd.sgdfback.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SeguimientoDAO {

    private final JdbcTemplate jdbcTemplate;

    public SeguimientoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findAllSeguimientos() {
        String sql = "SELECT s.id, s.tramite_id, u.username as usuario, r.name as rol, s.fecha_inicio, s.fecha_fin, s.carrera, s.visto, s.comentario as observacion, f.formulario, s.tiempo, s.estado "
                +
                "FROM seguimiento s " +
                "LEFT JOIN FLUJO f ON s.flujo = f.flujo AND s.proceso = f.proceso " +
                "LEFT JOIN user u ON s.user_id = u.id " +
                "LEFT JOIN role r ON s.role_id = r.id";
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> findRoleAndUnidadByUserId(Integer userId) {
        String sql = "SELECT r.id, ur.unidad_id FROM user_role ur " +
                "JOIN role r ON ur.role_id = r.id " +
                "WHERE ur.user_id = ?";
        return jdbcTemplate.queryForMap(sql, userId);
    }

    public List<Map<String, Object>> findPendientesByUserRoleAndCarrera(Integer rolId, String carrera, Integer userId) {
        String sqlSeg = "SELECT s.id AS seg_id, s.estado, s.comentario, f.formulario, t.id AS tram_id, t.tipo, s.tiempo, s.fecha_inicio, s.flujo, s.proceso, r.name AS role_name "
                + //
                "FROM seguimiento s " + //
                "JOIN tramite t ON s.tramite_id = t.id " + //
                "JOIN flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso " + //
                "LEFT JOIN role r ON s.role_id = r.id " + //
                "WHERE s.role_id = ? " + //
                "AND s.carrera = ? " + //
                "AND s.user_id = ? " + //
                "AND s.fecha_fin IS NULL";
        return jdbcTemplate.queryForList(sqlSeg, rolId, carrera, userId);
    }

    public List<Map<String, Object>> findConcluidosByUserRoleAndCarrera(Integer rolId, String carrera, Integer userId) {
        String sqlSeg = "SELECT s.id AS seg_id, s.estado, s.comentario, s.flujo, s.proceso, f.formulario, s.fecha_inicio, s.fecha_fin,"
                +
                "t.id AS tram_id, t.tipo, s.visto " +
                "FROM seguimiento s " +
                "JOIN tramite t ON s.tramite_id = t.id " +
                "JOIN flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso " +
                "WHERE s.role_id = ? " +
                "AND s.carrera = ? " +
                "AND s.user_id = ? " +
                "AND s.fecha_fin IS NOT NULL " +
                "AND (s.proceso LIKE '%Fin' OR s.estado = 'fuera de plazo')";
        return jdbcTemplate.queryForList(sqlSeg, rolId, carrera, userId);
    }

    public List<Map<String, Object>> findHR(Integer rolId, String carrera, Integer userId) {
        String sqlSeg = "SELECT t.id AS tram_id, t.tipo, " + //
                "GROUP_CONCAT(s.fecha_fin ORDER BY s.fecha_fin ASC SEPARATOR ', ') AS fechas_finalizacion, " + //
                "GROUP_CONCAT(f.formulario ORDER BY s.fecha_fin ASC SEPARATOR ', ') AS formularios, " + //
                "GROUP_CONCAT(s.estado ORDER BY s.fecha_fin ASC SEPARATOR ', ') AS estados " + //
                "FROM tramite t " + //
                "JOIN seguimiento s ON s.tramite_id = t.id " + //
                "JOIN flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso " + //
                "WHERE s.role_id = ? " + //
                "AND s.carrera = ? " + //
                "AND s.user_id = ? " + //
                "AND s.fecha_fin IS NOT NULL " + //
                "GROUP BY t.id, t.tipo " + //
                "ORDER BY t.id";
        return jdbcTemplate.queryForList(sqlSeg, rolId, carrera, userId);
    }

    public Integer countTramitesPendientes(Integer rolId, String carrera, Integer userId) {
        String sqlcount = "SELECT COUNT(s.id) AS tramites_pendientes " +
                "FROM seguimiento s " +
                "JOIN tramite t ON s.tramite_id = t.id " +
                "JOIN flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso " +
                "LEFT JOIN role r ON s.role_id = r.id " +
                "WHERE s.role_id = ? " +
                "AND s.carrera = ? " +
                "AND s.user_id = ? " +
                "AND s.fecha_fin IS NULL";
        return jdbcTemplate.queryForObject(sqlcount, Integer.class, rolId, carrera, userId);
    }

    public Integer countTramitesConcluidos(Integer rolId, String carrera, Integer userId) {
        String sqlcount = "SELECT COUNT(s.id) AS tramites_concluidos " + //
                        "FROM seguimiento s " + //
                        "JOIN tramite t ON s.tramite_id = t.id " + //
                        "JOIN flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso " + //
                        "LEFT JOIN role r ON s.role_id = r.id " + //
                        "WHERE s.role_id = ? " + //
                        "AND s.carrera = ? " + //
                        "AND s.user_id = ? " + //
                        "AND s.fecha_fin IS NOT NULL " + //
                        "AND (s.proceso LIKE '%Fin' OR s.estado = 'fuera de plazo') " + //
                        "AND s.visto LIKE 'false'";
        return jdbcTemplate.queryForObject(sqlcount, Integer.class, rolId, carrera, userId);
    }

    public void activateVisto(String flujo, String proceso, String nroTramite) {
        String sql = "UPDATE seguimiento SET visto = 'true' WHERE flujo = ? AND proceso = ? AND tramite_id = ?";
        jdbcTemplate.update(sql, flujo, proceso, nroTramite);
    }
}
