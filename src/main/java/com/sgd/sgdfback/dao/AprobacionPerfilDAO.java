package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.AprobacionPerfil;

@Repository
public interface AprobacionPerfilDAO extends JpaRepository<AprobacionPerfil, Integer> {
    AprobacionPerfil findByTramiteId(String tramiteId);
}
