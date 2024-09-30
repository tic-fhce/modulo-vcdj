package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.DesignacionDocentesInterinos;

@Repository
public interface DesignacionDocenteInterinoDAO extends JpaRepository<DesignacionDocentesInterinos, Integer> {
    DesignacionDocentesInterinos findByTramiteId(String tramiteId);
}
