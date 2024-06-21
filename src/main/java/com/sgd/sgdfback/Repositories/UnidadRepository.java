package com.sgd.sgdfback.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sgd.sgdfback.Models.Unidad;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, String>{
    Optional<Unidad> findByNombre(String nombre);
}
