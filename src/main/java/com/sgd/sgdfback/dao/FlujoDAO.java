package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgd.sgdfback.model.Flujo;

import java.util.List;

@Repository
public interface FlujoDAO extends JpaRepository<Flujo, Integer>{

    @Query("SELECT f FROM Flujo f " +
           "WHERE f.role.id = :roleId " +
           "AND f.habilitado = 'true' " +
           "AND (f.proceso = :proceso OR f.proceso LIKE CONCAT(:proceso, '-%'))")
    List<Flujo> findFlujosByRoleIdAndProceso(@Param("roleId") Integer roleId, 
                                             @Param("proceso") String proceso);

    
    // @Query("SELECT f FROM Flujo f LEFT JOIN FETCH f.procesos_cond")
    // List<Flujo> findAllWithProcesoCondicion();

    // @Query("SELECT f, pc FROM Flujo f LEFT JOIN ProcesoCondicion pc ON pc.flujo.id = f.id")
    // List<Object[]> findAllFlujosWithProcesoCondicion();
}
