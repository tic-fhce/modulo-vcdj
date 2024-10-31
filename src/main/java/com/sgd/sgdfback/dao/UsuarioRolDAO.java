package com.sgd.sgdfback.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.UsuarioRol;

@Repository
public interface UsuarioRolDAO extends JpaRepository<UsuarioRol, Integer> {
    UsuarioRol findFirstByUserId(Integer userId);

    @Query("SELECT ur FROM UsuarioRol ur WHERE ur.role.id = :rolId AND ur.unidad.id = :unidadId")
    Optional<UsuarioRol> findRolUnidad(@Param("rolId") Integer rolId, @Param("unidadId") String unidadId);


    @Query("SELECT ur FROM UsuarioRol ur WHERE ur.role.id = :rolId AND ur.unidad.id = :unidadId AND ur.user.id = :usuarioId")
    Optional<UsuarioRol> findUsuarioRolUnidad(@Param("rolId") Integer rolId, @Param("unidadId") String unidadId, @Param("usuarioId") Integer usuarioId);
}
