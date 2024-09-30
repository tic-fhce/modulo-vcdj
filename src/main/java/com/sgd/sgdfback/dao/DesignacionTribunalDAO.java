package com.sgd.sgdfback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgd.sgdfback.model.DesignacionTribunal;

import java.util.List;

@Repository
public interface DesignacionTribunalDAO extends JpaRepository<DesignacionTribunal, Integer> {
    DesignacionTribunal findByTramiteId(String tramiteId);
    List<DesignacionTribunal> findByUserId(Integer userId);
}
