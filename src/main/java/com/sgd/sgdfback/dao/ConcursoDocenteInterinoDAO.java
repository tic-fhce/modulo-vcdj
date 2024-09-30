package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.ConcursoDocentesInterinos;

@Repository
public interface ConcursoDocenteInterinoDAO extends JpaRepository<ConcursoDocentesInterinos, Integer> {
    ConcursoDocentesInterinos findByTramiteId(String tramiteId);
}
