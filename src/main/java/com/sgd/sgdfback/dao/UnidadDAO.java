package com.sgd.sgdfback.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.Unidad;

@Repository
public interface UnidadDAO extends JpaRepository<Unidad, String>{
    Optional<Unidad> findByNombre(String nombre);
}
