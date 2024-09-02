package com.sgd.sgdfback.Controller._05_Tramite;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TramiteService {

    private final TramiteRepository tramiteRepository;

    public List<Map<String, Object>> listarTramites() {
        return tramiteRepository.findAllTramites();
    }

    public List<Map<String, Object>> listarSeguimiento(Integer userId) {
        return tramiteRepository.findAllTramitesUser(userId);
    }
}

