package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.Tramite;

@Repository
public interface TramiteJpaDAO extends JpaRepository<Tramite, String>{
    
}
