package com.sgd.sgdfback.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkflowDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WorkflowDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTramite(String flujo, String formulario, Integer userId, String carrera) {
        String query = "INSERT INTO tramite (flujo, tipo, user_id, carrera, proceso, estado, creacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, flujo, formulario, userId, carrera, "P1", "pendiente", LocalDateTime.now());
    }

    public String getLastTramiteIdByUserId(Integer userId) {
        String query = "SELECT id FROM tramite WHERE user_id = ? ORDER BY creacion DESC LIMIT 1";
        return jdbcTemplate.queryForObject(query, String.class, userId);
    }
}
