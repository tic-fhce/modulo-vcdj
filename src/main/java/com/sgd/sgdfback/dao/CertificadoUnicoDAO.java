package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.CertificadoUnico;

@Repository
public interface CertificadoUnicoDAO extends JpaRepository<CertificadoUnico, Integer> {
    CertificadoUnico findByTramiteId(String tramiteId);
}
