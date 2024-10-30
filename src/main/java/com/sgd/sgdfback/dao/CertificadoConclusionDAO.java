package com.sgd.sgdfback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.CertificadoConclusion;

@Repository
public interface CertificadoConclusionDAO extends JpaRepository<CertificadoConclusion, Integer> {
    CertificadoConclusion findByTramiteId(String tramiteId);

    @Query("SELECT cc FROM CertificadoConclusion cc " +
            "JOIN cc.tramite t " +
            "WHERE t.carrera = :carrera " +
            "AND FUNCTION('YEAR', t.creacion) = :year")
    List<CertificadoConclusion> findByCarreraAndYear(@Param("carrera") String carrera,
                                                @Param("year") Integer year);

}
