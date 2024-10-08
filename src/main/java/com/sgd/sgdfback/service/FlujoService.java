package com.sgd.sgdfback.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.FlujoDAO;

@Service
public class FlujoService {

    private final FlujoDAO flujoRepository;

    public FlujoService(FlujoDAO flujoRepository) {
        this.flujoRepository = flujoRepository;
    }

    public List<Map<String, Object>> listarFlujosPorUsuarioYProceso(String username, String proceso) {
        Integer roleId = flujoRepository.findRoleIdByUsername(username);
        return flujoRepository.findFlujosByRoleIdAndProceso(roleId, proceso);
    }
}
