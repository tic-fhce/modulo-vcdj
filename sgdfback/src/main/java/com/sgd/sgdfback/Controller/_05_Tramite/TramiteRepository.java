package com.sgd.sgdfback.Controller._05_Tramite;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TramiteRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findAllTramites() {
        String sql = "SELECT t.id, t.carrera, t.tipo, f.formulario, u.username, t.estado, r.name AS unidad " +
                "FROM tramite t " +
                "LEFT JOIN flujo f ON t.flujo = f.flujo AND t.proceso = f.proceso " +
                "LEFT JOIN user u ON t.user_id = u.id " +
                "LEFT JOIN seguimiento s ON t.flujo = s.flujo AND t.proceso = s.proceso AND t.id = s.tramite_id " +
                "LEFT JOIN role r ON s.role_id = r.id";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> findAllTramitesUser(Integer userId) {
        String sql = "SELECT t.id, t.tipo, t.creacion, t.proceso, un.nombre AS carrera, f.formulario, t.estado, MAX(r.name) AS unidad " + //
                        "FROM tramite t " + //
                        "INNER JOIN user u ON t.user_id = u.id AND u.id = ? " + //
                        "LEFT JOIN flujo f ON t.flujo = f.flujo AND t.proceso = f.proceso " + //
                        "LEFT JOIN seguimiento s ON t.flujo = s.flujo AND t.proceso = s.proceso AND t.id = s.tramite_id " + //
                        "LEFT JOIN role r ON s.role_id = r.id " + //
                        "LEFT JOIN unidad un ON un.id = t.carrera " + //
                        "GROUP BY t.id, t.tipo, t.creacion, t.proceso, un.nombre, f.formulario, t.estado";
        return jdbcTemplate.queryForList(sql, userId);
    }
}
