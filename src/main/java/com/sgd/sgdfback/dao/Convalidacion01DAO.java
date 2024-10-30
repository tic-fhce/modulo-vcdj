package com.sgd.sgdfback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.Convalidacion01;

@Repository
public interface Convalidacion01DAO extends JpaRepository<Convalidacion01, Integer> {
    Convalidacion01 findByTramiteId(String tramiteId);

    @Query("SELECT c FROM Convalidacion01 c " +
            "JOIN c.tramite t " +
            "WHERE t.carrera = :carrera " +
            "AND FUNCTION('YEAR', t.creacion) = :year")
    List<Convalidacion01> findByCarreraAndYear(@Param("carrera") String carrera,
                                                @Param("year") Integer year);
}
