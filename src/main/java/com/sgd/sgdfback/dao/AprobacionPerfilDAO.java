package com.sgd.sgdfback.dao;

import java.util.List;

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
}
