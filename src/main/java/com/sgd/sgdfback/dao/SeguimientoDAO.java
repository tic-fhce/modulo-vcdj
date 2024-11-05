package com.sgd.sgdfback.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.Seguimiento;

@Repository
public interface SeguimientoDAO extends JpaRepository<Seguimiento, Integer> {

        @Query("SELECT new map(s.id as id, s.tramite.id as tramiteId, ur.user.username as usuario, ur.role.name as rol, "
                        + "s.fecha_inicio as fechaInicio, s.fecha_fin as fechaFin, "
                        + "ur.unidad.nombre as unidadNombre, "
                        + "s.visto as visto, s.comentario as observacion, f.formulario as formulario, "
                        + "s.tiempo as tiempo, s.estado as estado) "
                        + "FROM Seguimiento s "
                        + "JOIN s.tramite t "
                        + "JOIN s.usuarioRol ur "
                        + "JOIN ur.unidad u "
                        + "JOIN s.flujo f")
        List<Map<String, Object>> findAllSeguimientos();

        @Query("SELECT new map(r.id as rolId, ur.unidad.id as unidadId) "
                        + "FROM UsuarioRol ur "
                        + "JOIN ur.role r "
                        + "WHERE ur.user.id = :userId")
        Optional<Map<String, Object>> findRoleAndUnidadByUserId(@Param("userId") Integer userId);

        @Query("SELECT new map(s.id AS seg_id, s.estado AS estado, s.comentario AS comentario, ur.role.name AS role_name, ur.user.username AS username, "
                        + "t.id AS tram_id, s.fecha_inicio AS fecha_inicio, s.tiempo AS tiempo, f.formulario AS formulario, f.proceso AS proceso, f.flujo AS flujo) "
                        + "FROM Seguimiento s "
                        + "JOIN s.tramite t "
                        + "JOIN s.usuarioRol ur "
                        + "JOIN s.flujo f "
                        + "WHERE ur.role.id = :rolId AND ur.unidad.id = :unidadId AND ur.user.id = :userId "
                        + "AND s.fecha_fin IS NULL")
        List<Map<String, Object>> findPendientesByUserRoleAndCarrera(@Param("userId") Integer userId,
                        @Param("rolId") Integer rolId,
                        @Param("unidadId") String unidadId);

        @Query("SELECT new map(s.id as seg_id, s.estado as estado, s.comentario as comentario, f.flujo as flujo, "
                        + "f.proceso as proceso, f.formulario as formulario, s.fecha_inicio as fecha_inicio, "
                        + "s.fecha_fin as fecha_fin, t.id as tram_id, t.tipo as tipo, s.visto as visto) "
                        + "FROM Seguimiento s "
                        + "JOIN s.tramite t "
                        + "JOIN s.usuarioRol ur "
                        + "JOIN ur.unidad u "
                        + "JOIN s.flujo f "
                        + "WHERE ur.role.id = :rolId AND u.id = :unidadId AND ur.user.id = :userId "
                        + "AND s.fecha_fin IS NOT NULL "
                        + "AND (f.proceso LIKE '%Fin' OR s.estado = 'fuera de plazo')")
        List<Map<String, Object>> findConcluidosByUserRoleAndCarrera(@Param("userId") Integer userId,
                        @Param("rolId") Integer rolId,
                        @Param("unidadId") String unidadId);

        @Query(value = "SELECT t.id AS tram_id, t.tipo AS tipo, "
                        + "GROUP_CONCAT(s.fecha_fin ORDER BY s.fecha_fin ASC) AS fechas_finalizacion, "
                        + "GROUP_CONCAT(f.formulario ORDER BY s.fecha_fin ASC) AS formularios, "
                        + "GROUP_CONCAT(s.estado ORDER BY s.fecha_fin ASC) AS estados "
                        + "FROM tramite t "
                        + "JOIN seguimiento s ON t.id = s.tramite_id "
                        + "JOIN flujo f ON s.flujo_id = f.id "
                        + "JOIN user_role ur ON ur.id = s.usuario_rol_id "
                        + "WHERE ur.role_id = :rolId AND ur.unidad_id = :unidadId AND ur.user_id = :userId "
                        + "AND s.fecha_fin IS NOT NULL "
                        + "GROUP BY t.id, t.tipo "
                        + "ORDER BY t.id", nativeQuery = true)
        List<Map<String, Object>> findHR(@Param("rolId") Integer rolId,
                        @Param("unidadId") String unidadId,
                        @Param("userId") Integer userId);

        @Query("SELECT COUNT(s.id) "
                        + "FROM Seguimiento s "
                        + "JOIN s.tramite t "
                        + "JOIN s.flujo f "
                        + "JOIN s.usuarioRol ur "
                        + "WHERE ur.role.id = :rolId AND ur.unidad.id = :unidadId AND ur.user.id = :userId "
                        + "AND s.fecha_fin IS NULL")
        Integer countTramitesPendientes(@Param("rolId") Integer rolId,
                        @Param("unidadId") String unidadId,
                        @Param("userId") Integer userId);

        @Query("SELECT COUNT(s.id) "
                        + "FROM Seguimiento s "
                        + "JOIN s.tramite t "
                        + "JOIN s.flujo f "
                        + "JOIN s.usuarioRol ur "
                        + "WHERE ur.role.id = :rolId AND ur.unidad.id = :unidadId AND ur.user.id = :userId "
                        + "AND s.fecha_fin IS NOT NULL "
                        + "AND (f.proceso LIKE '%Fin' OR s.estado = 'fuera de plazo') "
                        + "AND (s.visto = 'false' OR s.visto IS NULL)")
        Integer countTramitesConcluidos(@Param("rolId") Integer rolId,
                        @Param("unidadId") String unidadId,
                        @Param("userId") Integer userId);

        @Query("SELECT s FROM Seguimiento s " +
                        "JOIN s.tramite t " +
                        "JOIN s.flujo f " +
                        "WHERE t.id = :tramiteId AND f.flujo = :flujo AND f.proceso = :proceso AND s.fecha_fin IS NULL")
        Optional<Seguimiento> findByTramiteId(@Param("tramiteId") String tramiteId,
                        @Param("flujo") String flujo,
                        @Param("proceso") String proceso);

        @Query("SELECT COUNT(s.id) FROM Seguimiento s " +
                        "JOIN s.tramite t " +
                        "JOIN s.flujo f " +
                        "WHERE t.id = :tramiteId AND f.id = :flujoId")
        Integer findObservadoCount(@Param("tramiteId") String tramiteId, @Param("flujoId") Integer flujoId);


        @Modifying
        @Query("UPDATE Seguimiento s SET s.estado = 'observado' " +
                        "WHERE s.tramite.id = :tramiteId AND s.flujo.id = :flujoId")
        Integer updateEstadoObservado(@Param("tramiteId") String tramiteId,
                        @Param("flujoId") Integer flujoId);

}
