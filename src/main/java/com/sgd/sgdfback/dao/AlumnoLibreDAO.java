package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.AlumnoLibre;

@Repository
public interface AlumnoLibreDAO extends JpaRepository<AlumnoLibre, Integer> {
    // Podemos agregar métodos personalizados si es necesario
    AlumnoLibre findByTramiteId(String tramiteId);
}
