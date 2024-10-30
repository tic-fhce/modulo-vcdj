package com.sgd.sgdfback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.Convalidacion02;

@Repository
public interface Convalidacion02DAO extends JpaRepository<Convalidacion02, Integer> {
    Convalidacion02 findByTramiteId(String tramiteId);

    @Query("SELECT c FROM Convalidacion02 c " +
            "JOIN c.tramite t " +
            "WHERE t.carrera = :carrera " +
            "AND FUNCTION('YEAR', t.creacion) = :year")
    List<Convalidacion02> findByCarreraAndYear(@Param("carrera") String carrera,
                                                @Param("year") Integer year);
}
