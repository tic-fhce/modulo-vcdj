package com.sgd.sgdfback.dao;

import com.sgd.sgdfback.model.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

@Repository
public interface TramiteDAO extends JpaRepository<Tramite, String> {

    @Query(value = "SELECT t.id, t.carrera, t.tipo, f.formulario, u.username, t.estado, r.name AS unidad " +
                "FROM tramite t " +
                "LEFT JOIN flujo f ON f.flujo = t.flujo AND f.proceso = t.proceso " +
                "LEFT JOIN seguimiento s ON s.flujo_id = f.id AND s.tramite_id = t.id " +
                "LEFT JOIN user_role ur ON ur.id = s.usuario_rol_id " +
                "LEFT JOIN user u ON u.id = ur.user_id " +
                "LEFT JOIN role r ON r.id = ur.role_id " +
                "ORDER BY t.id", 
           nativeQuery = true)
    List<Map<String, Object>> findAllTramites();

    @Query(value = "SELECT t.id, t.tipo, DATE_FORMAT(t.creacion, '%Y-%m-%d %H:%i') AS creacion, t.proceso, un.nombre AS carrera, f.formulario, t.estado, MAX(r.name) AS unidad " +
                "FROM tramite t " +
                "INNER JOIN user u ON t.user_id = u.id AND u.id = :userId " +
                "LEFT JOIN flujo f ON t.flujo = f.flujo AND t.proceso = f.proceso " +
                "LEFT JOIN seguimiento s ON s.flujo_id = f.id AND s.tramite_id = t.id " +
                "LEFT JOIN user_role ur ON ur.id = s.usuario_rol_id " +
                "LEFT JOIN role r ON r.id = ur.role_id " +
                "LEFT JOIN unidad un ON un.id = ur.unidad_id " +
                "GROUP BY t.id, t.tipo, t.creacion, t.proceso, un.nombre, f.formulario, t.estado",
           nativeQuery = true)
    List<Map<String, Object>> findAllTramitesUser(@Param("userId") Integer userId);

    @Query(value = "SELECT t.id, t.tipo, DATE_FORMAT(t.creacion, '%Y-%m-%d %H:%i:%s') AS creacion, t.proceso, un.nombre AS carrera, f.formulario, t.estado, r.name AS unidad " +
            "FROM tramite t " +
            "INNER JOIN user u ON t.user_id = u.id " +
            "LEFT JOIN flujo f ON t.flujo = f.flujo AND t.proceso = f.proceso " +
            "LEFT JOIN seguimiento s ON  s.flujo_id = f.id AND t.id = s.tramite_id " +
            "LEFT JOIN user_role ur ON ur.id = s.usuario_rol_id " +
            "LEFT JOIN role r ON r.id = ur.role_id " +
            "LEFT JOIN unidad un ON un.id = t.carrera AND un.id = ur.unidad_id " +
            "WHERE t.id = :id_tramite", nativeQuery = true)
    List<Map<String, Object>> findDatosHojaRuta(@Param("id_tramite") String idTramite);
}
