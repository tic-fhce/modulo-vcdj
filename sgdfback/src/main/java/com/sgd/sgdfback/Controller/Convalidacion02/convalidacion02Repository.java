package com.sgd.sgdfback.Controller.Convalidacion02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class convalidacion02Repository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public void updateColum(String colum, String param, String nroTramite) {
        String insertQuery = "UPDATE convalidacion_02 SET " + colum + " = ? WHERE tramite_id = ?";
        jdbcTemplate.update(insertQuery, param, nroTramite);
    }

    public String obtenerColumna(String nroTramite, String columna) {
        String sql = "SELECT " + columna + " FROM convalidacion_02 WHERE tramite_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, nroTramite);
    }
}
