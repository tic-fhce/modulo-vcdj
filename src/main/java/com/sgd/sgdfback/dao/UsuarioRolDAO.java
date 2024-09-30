package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.UsuarioRol;

@Repository
public interface UsuarioRolDAO extends JpaRepository<UsuarioRol, Integer>{
    UsuarioRol findFirstByUserId(Integer userId);
}
