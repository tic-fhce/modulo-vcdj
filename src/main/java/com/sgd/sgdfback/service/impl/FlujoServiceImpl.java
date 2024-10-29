package com.sgd.sgdfback.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.FlujoDAO;
import com.sgd.sgdfback.dao.UsuarioDAO;
import com.sgd.sgdfback.model.Flujo;
import com.sgd.sgdfback.model.Rol;
import com.sgd.sgdfback.service.FlujoService;

@Service
public class FlujoServiceImpl implements FlujoService {

    private final UsuarioDAO usuarioRepository;
    private final FlujoDAO flujoRepository;

    public FlujoServiceImpl(UsuarioDAO usuarioRepository, FlujoDAO flujoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.flujoRepository = flujoRepository;
    }

    @Override
    public List<Flujo> listarFlujosPorRoleIdYProceso(String username, String proceso) {
        Integer roleId = usuarioRepository.findRoleIdByUsername(username);

        if (roleId == null) {
            return Collections.emptyList();
        }

        return flujoRepository.findFlujosByRoleIdAndProceso(roleId, proceso);
    }

    @Override
    public void actualizarHabilitado(Integer id, String habilitado){
        Flujo flujo = flujoRepository.findById(id).orElseThrow(() -> new RuntimeException("Flujo no encontrado"));
        flujo.setHabilitado(habilitado);
        flujoRepository.save(flujo);
    }

    @Override
    public void actualizarProcedimiento(Integer id, String formulario, Integer rol, Integer tiempo){
        Rol role = new Rol();
        role.setId(rol);

        Flujo flujo = flujoRepository.findById(id).orElseThrow(() -> new RuntimeException("Flujo no encontrado"));
        flujo.setFormulario(formulario);
        flujo.setTiempo(tiempo);
        flujo.setRole(role);

        flujoRepository.save(flujo);
    }


    // Implementación del CRUD
    @Override
    public Flujo crearFlujo(Flujo flujo) {
        return flujoRepository.save(flujo);
    }

    @Override
    public Optional<Flujo> obtenerFlujoPorId(Integer id) {
        return flujoRepository.findById(id);
    }

    @Override
    public List<Flujo> obtenerTodosLosFlujos() {
        return flujoRepository.findAll();
    }

    @Override
    public Flujo actualizarFlujo(Integer id, Flujo flujo) {
        if (flujoRepository.existsById(id)) {
            flujo.setId(id);
            return flujoRepository.save(flujo);
        }
        return null;
    }

    @Override
    public void eliminarFlujo(Integer id) {
        if (flujoRepository.existsById(id)) {
            flujoRepository.deleteById(id);
        } else {
            throw new RuntimeException("La convalidación con ID " + id + " no existe.");
        }
    }

}
