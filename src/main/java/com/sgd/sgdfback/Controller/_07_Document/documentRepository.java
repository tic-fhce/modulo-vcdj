package com.sgd.sgdfback.Controller._07_Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class documentRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public Integer countByTramiteId(String tramiteId, String tabla) {
        String countQuery = "SELECT COUNT(*) FROM " + tabla + " WHERE tramite_id = ?";
        return jdbcTemplate.queryForObject(countQuery, Integer.class, tramiteId);
    }

    public void updateConvalidacion(String fileName, String newFileName, String nroTramite, String tabla) {
        String insertQuery = "UPDATE " + tabla + " SET d_" + fileName + " = ? WHERE tramite_id = ?";
        jdbcTemplate.update(insertQuery, newFileName, nroTramite);
    }

    public void insertConvalidacion(Integer userId, String fileName, String newFileName, String tramiteId, String tabla) {
        String insertQuery = "INSERT INTO " + tabla + " (d_" + fileName
                + ", tramite_id, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertQuery, newFileName, tramiteId, userId);
    }

    public String obtenerNombreArchivo(String nroTramite, String columna, String tabla) {
        String sql = "SELECT d_" + columna + " FROM " + tabla + " WHERE tramite_id = (?)";
        return jdbcTemplate.queryForObject(sql, String.class, nroTramite);
    }

    public void actualizarObservacionDoc(String columna, String observacion, String nroTramite, String tabla){
        String insertQuery = "UPDATE " + tabla + " SET r_" + columna + " = ? WHERE tramite_id = ?";
        jdbcTemplate.update(insertQuery, observacion, nroTramite);
    }

    public String obtenerObservacionArchivo(String nroTramite, String columna, String tabla) {
        String sql = "SELECT r_" + columna + " FROM " + tabla + " WHERE tramite_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, nroTramite);
    }
}
