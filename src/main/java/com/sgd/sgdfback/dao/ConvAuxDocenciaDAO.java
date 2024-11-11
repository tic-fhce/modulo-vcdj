package com.sgd.sgdfback.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.ConvAuxDocencia;

@Repository
public interface ConvAuxDocenciaDAO extends JpaRepository<ConvAuxDocencia, Integer> {
    ConvAuxDocencia findByTramiteId(String tramiteId);

    @Query("SELECT ca FROM ConvAuxDocencia ca WHERE ca.tramite.id = :tramiteId")
    Optional<ConvAuxDocencia> findByConvocatoriaId(@Param("tramiteId") String tramiteId);
}
