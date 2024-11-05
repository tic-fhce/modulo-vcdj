package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.DesignacionTribunal;

import java.util.List;
import java.util.Optional;

@Repository
public interface DesignacionTribunalDAO extends JpaRepository<DesignacionTribunal, Integer> {
        DesignacionTribunal findByTramiteId(String tramiteId);

        List<DesignacionTribunal> findByUserId(Integer userId);

        @Query("SELECT dt FROM DesignacionTribunal dt " +
                        "JOIN dt.tramite t " +
                        "WHERE t.carrera = :carrera " +
                        "AND FUNCTION('YEAR', t.creacion) = :year")
        List<DesignacionTribunal> findByCarreraAndYear(@Param("carrera") String carrera,
                        @Param("year") Integer year);


        @Query("SELECT dt FROM DesignacionTribunal dt WHERE dt.tramite.id = :tramiteId")
        Optional<DesignacionTribunal> findByDesignacionTramiteId(@Param("tramiteId") String tramiteId);


        @Query(value = "SELECT t.id FROM tramite t WHERE t.flujo = 'F19' AND t.user_id = :userId AND t.carrera = :carrera", nativeQuery = true)
        String findTramiteIdByAprobacionPerfil(@Param("userId") Integer userId,
                        @Param("carrera") String carrera);

}
