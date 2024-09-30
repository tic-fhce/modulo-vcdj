package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.CambioModalidad;

@Repository
public interface CambioModalidadDAO extends JpaRepository<CambioModalidad, Integer> {
    CambioModalidad findByTramiteId(String tramiteId);
}
