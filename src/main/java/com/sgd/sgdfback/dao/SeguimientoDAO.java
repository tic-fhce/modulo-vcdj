package com.sgd.sgdfback.dao;

import com.sgd.sgdfback.model.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

@Repository
public interface SeguimientoDAO extends JpaRepository<Seguimiento, Integer> {

    @Query("SELECT new map(s.id as id, s.tramite.id as tramiteId, u.username as usuario, r.name as rol, "
            + "s.fecha_inicio as fechaInicio, s.fecha_fin as fechaFin, s.carrera as carrera, "
            + "s.visto as visto, s.comentario as observacion, f.formulario as formulario, "
            + "s.tiempo as tiempo, s.estado as estado) "
            + "FROM Seguimiento s "
            + "LEFT JOIN s.tramite t "
            + "LEFT JOIN s.user u "
            + "LEFT JOIN s.role r "
            + "LEFT JOIN Flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso")
    List<Map<String, Object>> findAllSeguimientos();

    @Query("SELECT new map(r.id as rolId, ur.unidad.id as unidadId) "
            + "FROM UsuarioRol ur "
            + "JOIN ur.role r "
            + "WHERE ur.user.id = :userId")
    Optional<Map<String, Object>> findRoleAndUnidadByUserId(@Param("userId") Integer userId);

    
    @Query("SELECT new map(s.id AS seg_id, s.estado AS estado, s.comentario AS comentario, r.name AS role_name, u.username AS username, "
            + "t.id AS tram_id, s.fecha_inicio AS fecha_inicio, s.tiempo AS tiempo, f.formulario AS formulario, s.flujo AS flujo, s.proceso AS proceso) "
            + "FROM Seguimiento s "
            + "JOIN s.tramite t "
            + "JOIN s.role r "
            + "JOIN s.user u "
            + "JOIN Flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso "
            + "WHERE s.role.id = :rolId AND s.carrera = :carrera AND s.user.id = :userId "
            + "AND s.fecha_fin IS NULL")
    List<Map<String, Object>> findPendientesByUserRoleAndCarrera(@Param("rolId") Integer rolId,
            @Param("carrera") String carrera,
            @Param("userId") Integer userId);

    
    @Query("SELECT new map(s.id as segId, s.estado as estado, s.comentario as comentario, s.flujo as flujo, "
            + "s.proceso as proceso, f.formulario as formulario, s.fecha_inicio as fecha_inicio, "
            + "s.fecha_fin as fecha_fin, t.id as tram_id, t.tipo as tipo, s.visto as visto) "
            + "FROM Seguimiento s "
            + "JOIN s.tramite t "
            + "JOIN Flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso "
            + "WHERE s.role.id = :rolId AND s.carrera = :carrera AND s.user.id = :userId "
            + "AND s.fecha_fin IS NOT NULL "
            + "AND (s.proceso LIKE '%Fin' OR s.estado = 'fuera de plazo')")
    List<Map<String, Object>> findConcluidosByUserRoleAndCarrera(@Param("rolId") Integer rolId,
            @Param("carrera") String carrera,
            @Param("userId") Integer userId);


    @Query(value = "SELECT t.id as tram_id, t.tipo as tipo, "
            + "GROUP_CONCAT(s.fecha_fin ORDER BY s.fecha_fin ASC) as fechas_finalizacion, "
            + "GROUP_CONCAT(f.formulario ORDER BY s.fecha_fin ASC) as formularios, "
            + "GROUP_CONCAT(s.estado ORDER BY s.fecha_fin ASC) as estados "
            + "FROM tramite t "
            + "JOIN seguimiento s ON t.id = s.tramite_id "
            + "JOIN flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso "
            + "WHERE s.role_id = :rolId AND s.carrera = :carrera AND s.user_id = :userId "
            + "AND s.fecha_fin IS NOT NULL "
            + "GROUP BY t.id, t.tipo ORDER BY t.id", nativeQuery = true)
    List<Map<String, Object>> findHR(@Param("rolId") Integer rolId,
            @Param("carrera") String carrera,
            @Param("userId") Integer userId);


    @Query(value = "SELECT COUNT(s.id) AS tramites_pendientes FROM seguimiento s "
            + "JOIN tramite t ON s.tramite_id = t.id "
            + "JOIN flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso "
            + "LEFT JOIN role r ON s.role_id = r.id "
            + "WHERE s.role_id = :rolId AND s.carrera = :carrera AND s.user_id = :userId "
            + "AND s.fecha_fin IS NULL", nativeQuery = true)
    Integer countTramitesPendientes(@Param("rolId") Integer rolId,
            @Param("carrera") String carrera,
            @Param("userId") Integer userId);


    @Query(value = "SELECT COUNT(s.id) AS tramites_concluidos FROM seguimiento s "
            + "JOIN tramite t ON s.tramite_id = t.id "
            + "JOIN flujo f ON s.flujo = f.flujo AND s.proceso = f.proceso "
            + "LEFT JOIN role r ON s.role_id = r.id "
            + "WHERE s.role_id = :rolId AND s.carrera = :carrera AND s.user_id = :userId "
            + "AND s.fecha_fin IS NOT NULL "
            + "AND (s.proceso LIKE '%Fin' OR s.estado = 'fuera de plazo') "
            + "AND s.visto = false", nativeQuery = true)
    Integer countTramitesConcluidos(@Param("rolId") Integer rolId,
            @Param("carrera") String carrera,
            @Param("userId") Integer userId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE seguimiento s SET s.visto = 'true' "
            + "WHERE s.flujo = :flujo AND s.proceso = :proceso AND s.tramite_id = :tramiteId", nativeQuery = true)
    void activateVisto(@Param("flujo") String flujo,
            @Param("proceso") String proceso,
            @Param("tramiteId") String tramiteId);



}
