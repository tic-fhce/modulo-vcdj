package com.sgd.sgdfback.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.ConvDocContratados;

@Repository
public interface ConvDocContratadosDAO extends JpaRepository<ConvDocContratados, Integer> {
    ConvDocContratados findByTramiteId(String tramiteId);

    @Query("SELECT cd FROM ConvDocContratados cd WHERE cd.tramite.id = :tramiteId")
        Optional<ConvDocContratados> findByConvocatoriaId(@Param("tramiteId") String tramiteId);
}
