package com.sgd.sgdfback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.AlumnoLibre;

@Repository
public interface AlumnoLibreDAO extends JpaRepository<AlumnoLibre, Integer> {
    // Podemos agregar métodos personalizados si es necesario
    AlumnoLibre findByTramiteId(String tramiteId);

    @Query("SELECT al FROM AlumnoLibre al " +
            "JOIN al.tramite t " +
            "WHERE t.carrera = :carrera " +
            "AND FUNCTION('YEAR', t.creacion) = :year")
    List<AlumnoLibre> findByCarreraAndYear(@Param("carrera") String carrera,
                                                @Param("year") Integer year);
}
