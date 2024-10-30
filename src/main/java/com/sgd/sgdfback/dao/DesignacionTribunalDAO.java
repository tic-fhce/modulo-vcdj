package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.DesignacionTribunal;

import java.util.List;

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
}
