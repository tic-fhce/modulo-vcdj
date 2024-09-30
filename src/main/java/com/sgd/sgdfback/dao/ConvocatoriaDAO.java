package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.Convocatoria;

@Repository
public interface ConvocatoriaDAO extends JpaRepository<Convocatoria, Integer> {
    Convocatoria findByTramiteId(String tramiteId);
}
