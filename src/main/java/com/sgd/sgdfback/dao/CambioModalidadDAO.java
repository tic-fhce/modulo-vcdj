package com.sgd.sgdfback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.CambioModalidad;

@Repository
public interface CambioModalidadDAO extends JpaRepository<CambioModalidad, Integer> {
    CambioModalidad findByTramiteId(String tramiteId);

    @Query("SELECT cm FROM CambioModalidad cm " +
            "JOIN cm.tramite t " +
            "WHERE t.carrera = :carrera " +
            "AND FUNCTION('YEAR', t.creacion) = :year")
    List<CambioModalidad> findByCarreraAndYear(@Param("carrera") String carrera,
                                                @Param("year") Integer year);
}
