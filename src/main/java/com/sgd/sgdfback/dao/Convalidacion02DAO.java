package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.Convalidacion02;

@Repository
public interface Convalidacion02DAO extends JpaRepository<Convalidacion02, Integer> {
    Convalidacion02 findByTramiteId(String tramiteId);
}
