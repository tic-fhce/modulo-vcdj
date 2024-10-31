package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.Flujo;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlujoDAO extends JpaRepository<Flujo, Integer> {

       @Query("SELECT f FROM Flujo f " +
                     "WHERE f.role.id = :roleId " +
                     "AND f.habilitado = 'true' " +
                     "AND (f.proceso = :proceso OR f.proceso LIKE CONCAT(:proceso, '-%'))")
       List<Flujo> findFlujosByRoleIdAndProceso(@Param("roleId") Integer roleId,
                     @Param("proceso") String proceso);

       @Query("SELECT f FROM Flujo f WHERE f.flujo = :flujo AND f.proceso = :proceso")
       Optional<Flujo> findFlujoByFlujoAndProceso(@Param("flujo") String flujo, @Param("proceso") String proceso);

       /*@Query("SELECT f.tiempo FROM Flujo f WHERE f.flujo = :flujo AND f.proceso = :proceso")
       Integer getTiempoByFlujoAndProceso(@Param("flujo") String flujo, @Param("proceso") String proceso);*/
}
