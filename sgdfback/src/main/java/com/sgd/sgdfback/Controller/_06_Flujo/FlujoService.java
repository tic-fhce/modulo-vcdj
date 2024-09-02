package com.sgd.sgdfback.Controller._06_Flujo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FlujoService {

    private final FlujoRepository flujoRepository;

    public List<Map<String, Object>> listarFlujosPorUsuarioYProceso(String username, String proceso) {
        Integer roleId = flujoRepository.findRoleIdByUsername(username);
        return flujoRepository.findFlujosByRoleIdAndProceso(roleId, proceso);
    }
}

