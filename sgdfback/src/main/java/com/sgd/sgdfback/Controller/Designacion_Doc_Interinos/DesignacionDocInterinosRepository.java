package com.sgd.sgdfback.Controller.Designacion_Doc_Interinos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DesignacionDocInterinosRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public void updateColum(String colum, String param, String nroTramite) {
        String insertQuery = "UPDATE designacion_doc_interinos SET " + colum + " = ? WHERE tramite_id = ?";
        jdbcTemplate.update(insertQuery, param, nroTramite);
    }

    public String obtenerColumna(String nroTramite, String columna) {
        String sql = "SELECT " + columna + " FROM designacion_doc_interinos WHERE tramite_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, nroTramite);
    }
}
