package com.sgd.sgdfback.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.Rol;
import com.sgd.sgdfback.model.RolNombre;

@Repository
public interface RolDAO extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByName(RolNombre roleName);

    
}
