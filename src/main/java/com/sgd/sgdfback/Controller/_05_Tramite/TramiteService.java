package com.sgd.sgdfback.Controller._05_Tramite;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TramiteService {

    private final TramiteRepository tramiteRepository;

    public List<Map<String, Object>> listarTramites() {
        return tramiteRepository.findAllTramites();
    }
}

