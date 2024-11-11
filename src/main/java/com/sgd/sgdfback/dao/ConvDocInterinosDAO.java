package com.sgd.sgdfback.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.ConvDocInterinos;

@Repository
public interface ConvDocInterinosDAO extends JpaRepository<ConvDocInterinos, Integer> {
    ConvDocInterinos findByTramiteId(String tramiteId);

    @Query("SELECT cd FROM ConvDocInterinos cd WHERE cd.tramite.id = :tramiteId")
        Optional<ConvDocInterinos> findByConvocatoriaId(@Param("tramiteId") String tramiteId);
}
