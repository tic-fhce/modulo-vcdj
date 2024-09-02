package com.sgd.sgdfback.Controller._06_Flujo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class FlujoRepository {

    private final JdbcTemplate jdbcTemplate;

    public Integer findRoleIdByUsername(String username) {
        String sql = "SELECT r.id FROM user u " +
                     "INNER JOIN user_role ur ON u.id = ur.user_id " +
                     "INNER JOIN role r ON ur.role_id = r.id " +
                     "WHERE u.username = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, username);
    }

    public List<Map<String, Object>> findFlujosByRoleIdAndProceso(Integer roleId, String proceso) {
        String sql = "SELECT * FROM flujo WHERE role_id = ? AND proceso LIKE ? OR proceso LIKE ?";
        return jdbcTemplate.queryForList(sql, roleId, proceso, proceso + "-%");
    }
}
