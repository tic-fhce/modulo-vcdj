package com.sgd.sgdfback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.MateriaExtra;

@Repository
public interface MateriaExtraDAO extends JpaRepository<MateriaExtra, Integer> {
    MateriaExtra findByTramiteId(String tramiteId);

    @Query("SELECT me FROM MateriaExtra me " +
            "JOIN me.tramite t " +
            "WHERE t.carrera = :carrera " +
            "AND FUNCTION('YEAR', t.creacion) = :year")
    List<MateriaExtra> findByCarreraAndYear(@Param("carrera") String carrera,
                                                @Param("year") Integer year);
}
