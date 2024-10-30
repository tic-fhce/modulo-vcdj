package com.sgd.sgdfback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.CertificadoUnico;

@Repository
public interface CertificadoUnicoDAO extends JpaRepository<CertificadoUnico, Integer> {
    CertificadoUnico findByTramiteId(String tramiteId);

    @Query("SELECT cu FROM CertificadoUnico cu " +
            "JOIN cu.tramite t " +
            "WHERE t.carrera = :carrera " +
            "AND FUNCTION('YEAR', t.creacion) = :year")
    List<CertificadoUnico> findByCarreraAndYear(@Param("carrera") String carrera,
                                                @Param("year") Integer year);

}
