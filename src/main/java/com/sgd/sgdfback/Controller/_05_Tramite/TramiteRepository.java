package com.sgd.sgdfback.Controller._05_Tramite;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

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
}

