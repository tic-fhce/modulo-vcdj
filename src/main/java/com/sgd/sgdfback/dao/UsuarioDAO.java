package com.sgd.sgdfback.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByUsername(String username);

    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.cif LIKE :cod%")
    int countByCif(String cod);

    @Query("SELECT ur.role.id FROM Usuario u " +
           "JOIN u.user_roles ur " +
           "WHERE u.username = :username")
    Integer findRoleIdByUsername(@Param("username") String username);
}
