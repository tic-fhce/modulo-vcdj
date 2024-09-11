package com.sgd.sgdfback.Controller.CambioModalidad;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class cambioModalidadRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public void updateColum(String colum, String param, String nroTramite) {
        String insertQuery = "UPDATE cambio_modalidad SET " + colum + " = ? WHERE tramite_id = ?";
        jdbcTemplate.update(insertQuery, param, nroTramite);
    }

    public String obtenerColumna(String nroTramite, String columna) {
        String sql = "SELECT " + columna + " FROM cambio_modalidad WHERE tramite_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, nroTramite);
    }

    public Map<String, Object> obtenerTodoPorTramiteId(String nroTramite) {
        String sql = "SELECT aprobacion_perfil_id, user_id, cambio, n_modalidad, n_titulo, n_tutor FROM cambio_modalidad WHERE tramite_id = ?";
        return jdbcTemplate.queryForMap(sql, nroTramite);
    }
    
}

