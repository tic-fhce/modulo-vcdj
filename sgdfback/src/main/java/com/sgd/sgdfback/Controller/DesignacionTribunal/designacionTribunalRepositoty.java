package com.sgd.sgdfback.Controller.DesignacionTribunal;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class designacionTribunalRepositoty {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public void updateColum(String colum, String param, String nroTramite) {
        String insertQuery = "UPDATE designacion_tribunal SET " + colum + " = ? WHERE tramite_id = ?";
        jdbcTemplate.update(insertQuery, param, nroTramite);
    }

    public String obtenerColumna(String nroTramite, String columna) {
        String sql = "SELECT " + columna + " FROM designacion_tribunal WHERE tramite_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, nroTramite);
    }

    public List<Map<String, Object>> obtenerAprobacionPerfil(Integer userId) {
        String sql = "SELECT * FROM aprobacion_perfil WHERE user_id = ?";
        return jdbcTemplate.queryForList(sql, userId);
    }

    public List<Map<String, Object>> obtenerAprobacionPerfilId(Integer perfilId) {
        String sql = "SELECT * FROM aprobacion_perfil WHERE id = ?";
        return jdbcTemplate.queryForList(sql, perfilId);
    }
}
