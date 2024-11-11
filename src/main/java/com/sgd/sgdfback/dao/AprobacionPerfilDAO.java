package com.sgd.sgdfback.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.AprobacionPerfil;

@Repository
public interface AprobacionPerfilDAO extends JpaRepository<AprobacionPerfil, Integer> {
        AprobacionPerfil findByTramiteId(String tramiteId);

        @Query("SELECT ap FROM AprobacionPerfil ap " +
                        "JOIN ap.tramite t " +
                        "WHERE t.carrera = :carrera " +
                        "AND FUNCTION('YEAR', t.creacion) = :year")
        List<AprobacionPerfil> findByCarreraAndYear(@Param("carrera") String carrera,
                        @Param("year") Integer year);

        @Query("SELECT ap FROM AprobacionPerfil ap WHERE ap.tramite.id = :tramiteId")
        Optional<AprobacionPerfil> findByAprobacionTramiteId(@Param("tramiteId") String tramiteId);

        /*
         * @Query("SELECT ap FROM AprobacionPerfil ap " +
         * "JOIN ap.tramite t " +
         * "WHERE t.user_id = :userId " +
         * "ORDER BY t.creacion DESC")
         * Optional<AprobacionPerfil> findByUltimaAprobacionPerfil(@Param("userId")
         * Integer userId);
         */

        @Query(value = "SELECT ap.* FROM aprobacion_perfil ap " +
                        "JOIN tramite t ON ap.tramite_id = t.id " +
                        "WHERE t.user_id = :userId " +
                        "ORDER BY t.creacion DESC LIMIT 1", nativeQuery = true)
        Optional<AprobacionPerfil> findByUltimaAprobacionPerfil(@Param("userId") Integer userId);

}
