package com.sgd.sgdfback.Controller.Convocatoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class convocatoriaRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public void updateColum(String colum, String param, String nroTramite, Integer userId) {
        // Intentar actualizar
        String updateQuery = "UPDATE convocatoria SET " + colum + " = ? WHERE tramite_id = ?";
        int rowsAffected = jdbcTemplate.update(updateQuery, param, nroTramite);

        // Si no se actualizó ninguna fila, realizar una inserción
        if (rowsAffected == 0) {
            String insertQuery = "INSERT INTO convocatoria (tramite_id, " + colum + ", user_id) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertQuery, nroTramite, param, userId);
        }
    }

    public String obtenerColumna(String nroTramite, String columna) {
        String sql = "SELECT " + columna + " FROM convocatoria WHERE tramite_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, nroTramite);
    }
}

