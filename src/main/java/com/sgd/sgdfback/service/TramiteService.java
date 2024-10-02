package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.TramiteDAO;

@Service
public class TramiteService {

    private final TramiteDAO tramiteRepository;

    public TramiteService(TramiteDAO tramiteRepository) {
        this.tramiteRepository = tramiteRepository;
    }

    public List<Map<String, Object>> listarTramites() {
        return tramiteRepository.findAllTramites();
    }

    public List<Map<String, Object>> listarSeguimiento(Integer userId) {
        return tramiteRepository.findAllTramitesUser(userId);
    }
}

