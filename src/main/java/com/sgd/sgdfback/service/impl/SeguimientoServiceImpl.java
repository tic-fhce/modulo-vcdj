package com.sgd.sgdfback.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.SeguimientoDAO;
import com.sgd.sgdfback.model.Seguimiento;
import com.sgd.sgdfback.service.SeguimientoService;
import com.sgd.sgdfback.model.Usuario;

@Service
public class SeguimientoServiceImpl implements SeguimientoService {

    private final SeguimientoDAO seguimientoRepository;

    public SeguimientoServiceImpl(SeguimientoDAO seguimientoRepository) {
        this.seguimientoRepository = seguimientoRepository;
    }
    
    public List<Map<String, Object>> listarSeguimientos() {
        return seguimientoRepository.findAllSeguimientos();
    }

    @Override
    public List<Map<String, Object>> listarTramitesPendientes(Usuario user) {
        Integer userId = user.getId();
        Integer rolId = user.getUser_roles().get(0).getRole().getId();
        String unidadId = user.getUser_roles().get(0).getUnidad().getId();

        return seguimientoRepository.findPendientesByUserRoleAndCarrera(userId, rolId, unidadId);
    }

    @Override
    public List<Map<String, Object>> listarTramitesConcluidos(Usuario user) {
        Integer userId = user.getId();
        Integer rolId = user.getUser_roles().get(0).getRole().getId();
        String unidadId = user.getUser_roles().get(0).getUnidad().getId();

        return seguimientoRepository.findConcluidosByUserRoleAndCarrera(userId, rolId, unidadId);
    }

    @Override
    public List<Map<String, Object>> listarHR(Usuario user) {
        Integer userId = user.getId();
        Integer rolId = user.getUser_roles().get(0).getRole().getId();
        String unidadId = user.getUser_roles().get(0).getUnidad().getId();

        return seguimientoRepository.findHR(rolId, unidadId, userId);
    }

    @Override
    public Integer countTramitesPend(Usuario user){
        Integer userId = user.getId();
        Integer rolId = user.getUser_roles().get(0).getRole().getId();
        String unidadId = user.getUser_roles().get(0).getUnidad().getId();

        return seguimientoRepository.countTramitesPendientes(rolId, unidadId, userId);
    }

    @Override
    public Integer countTramitesConcl(Usuario user){
        Integer userId = user.getId();
        Integer rolId = user.getUser_roles().get(0).getRole().getId();
        String unidadId = user.getUser_roles().get(0).getUnidad().getId();

        return seguimientoRepository.countTramitesConcluidos(rolId, unidadId, userId);
    }

    @Override
    public void activateV(Integer id) {
        Seguimiento seguimiento = seguimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("Seguimiento no encontrado"));
        seguimiento.setVisto("true");
        seguimientoRepository.save(seguimiento);
    }

    // Implementación del CRUD
    @Override
    public Seguimiento crearSeguimiento(Seguimiento seguimiento) {
        return seguimientoRepository.save(seguimiento);
    }

    @Override
    public Optional<Seguimiento> obtenerSeguimientoPorId(Integer id) {
        return seguimientoRepository.findById(id);
    }

    @Override
    public List<Seguimiento> obtenerTodosLosSeguimientos() {
        return seguimientoRepository.findAll();
    }

    @Override
    public Seguimiento actualizarFlujo(Integer id, Seguimiento seguimiento) {
        if (seguimientoRepository.existsById(id)) {
            seguimiento.setId(id);
            return seguimientoRepository.save(seguimiento);
        }
        return null;
    }

    @Override
    public void eliminarSeguimiento(Integer id) {
        if (seguimientoRepository.existsById(id)) {
            seguimientoRepository.deleteById(id);
        } else {
            throw new RuntimeException("El seguimiento con ID " + id + " no existe.");
        }
    }
}
