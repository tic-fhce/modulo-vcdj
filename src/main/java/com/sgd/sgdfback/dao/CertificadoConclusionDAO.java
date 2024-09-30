package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.CertificadoConclusion;

@Repository
public interface CertificadoConclusionDAO extends JpaRepository<CertificadoConclusion, Integer> {
    CertificadoConclusion findByTramiteId(String tramiteId);
}
