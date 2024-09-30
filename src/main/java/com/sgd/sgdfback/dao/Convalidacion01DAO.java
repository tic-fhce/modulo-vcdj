package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.Convalidacion01;

@Repository
public interface Convalidacion01DAO extends JpaRepository<Convalidacion01, Integer> {
    Convalidacion01 findByTramiteId(String tramiteId);
}
