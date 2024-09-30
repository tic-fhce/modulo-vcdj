package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.MateriaExtra;

@Repository
public interface MateriaExtraDAO extends JpaRepository<MateriaExtra, Integer> {
    MateriaExtra findByTramiteId(String tramiteId);
}
