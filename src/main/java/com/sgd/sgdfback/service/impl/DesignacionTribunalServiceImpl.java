package com.sgd.sgdfback.service.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sgd.sgdfback.dao.AprobacionPerfilDAO;
import com.sgd.sgdfback.dao.DesignacionTribunalDAO;
import com.sgd.sgdfback.dao.TramiteDAO;
import com.sgd.sgdfback.model.AprobacionPerfil;
import com.sgd.sgdfback.model.DesignacionTribunal;
import com.sgd.sgdfback.model.Tramite;
import com.sgd.sgdfback.model.Usuario;
import com.sgd.sgdfback.service.DesignacionTribunalService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DesignacionTribunalServiceImpl implements DesignacionTribunalService {

    private final DesignacionTribunalDAO designacionTribunalRepository;
    private final TramiteDAO tramiteDAO;
    private final AprobacionPerfilDAO aprobacionPerfilDAO;

    public DesignacionTribunalServiceImpl(DesignacionTribunalDAO designacionTribunalRepository, TramiteDAO tramiteDAO, AprobacionPerfilDAO aprobacionPerfilDAO) {
        this.designacionTribunalRepository = designacionTribunalRepository;
        this.tramiteDAO = tramiteDAO;
        this.aprobacionPerfilDAO = aprobacionPerfilDAO;
    }
    
    @Override
    public void actualizarColumna(String columna, String param, String nroTramite) {
        DesignacionTribunal designacionTribunal = designacionTribunalRepository.findByTramiteId(nroTramite);
        if (designacionTribunal != null) {
            try {
                Field field = DesignacionTribunal.class.getDeclaredField(columna);
                field.setAccessible(true);
                field.set(designacionTribunal, param);
                designacionTribunalRepository.save(designacionTribunal);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la designación con el trámite especificado");
        }
    }

    @Override
    public String obtenerColumna(String nroTramite, String columna) {
        DesignacionTribunal designacionTribunal = designacionTribunalRepository.findByTramiteId(nroTramite);
        if (designacionTribunal != null) {
            try {
                Field field = DesignacionTribunal.class.getDeclaredField(columna);
                field.setAccessible(true);
                return (String) field.get(designacionTribunal);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error obteniendo la columna: " + columna, e);
            }
        } else {
            throw new RuntimeException("No se encontró la designación con el trámite especificado");
        }
    }

    @Override
    public DesignacionTribunal crearDesignacionTribunal(Usuario user, String nrotramite) {
        try {
            String nroTramitePerfil = designacionTribunalRepository.findTramiteIdByAprobacionPerfil(user.getId(), user.getUser_roles().get(0).getUnidad().getId());
            System.out.println(nroTramitePerfil);
            AprobacionPerfil ap = aprobacionPerfilDAO.findByAprobacionTramiteId(nroTramitePerfil).orElseThrow(() -> new RuntimeException("Aprobacion perfil no encontrado"));

            Tramite t2 = tramiteDAO.findById(nrotramite).orElseThrow(() -> new RuntimeException("Trámite no encontrado"));
            
            DesignacionTribunal dt = new DesignacionTribunal();
            dt.setTramite(t2);
            dt.setAprobacion_Perfil(ap);
            return designacionTribunalRepository.save(dt);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Error: Trámite no encontrado. Por favor, verifica el número del trámite.", e);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error de acceso a datos al guardar la aprobación de perfil.", e);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error inesperado al crear la aprobación de perfil.", e);
        }
    }

    @Override
    public Optional<DesignacionTribunal> obtenerDesignacionPorTramite(String nroTramite) {
        return designacionTribunalRepository.findByDesignacionTramiteId(nroTramite);
    }

    @Override
    public List<DesignacionTribunal> obtenerAprobacionPerfilPorUsuario(Integer userId) {
        return designacionTribunalRepository.findByUserId(userId);
    }

    @Override
    public List<DesignacionTribunal> obtenerAprobacionPerfilsCarreraYear(String carrera, Integer year){
        return designacionTribunalRepository.findByCarreraAndYear(carrera, year);
    }




    // Implementación del CRUD
    @Override
    public DesignacionTribunal crearDesignacion(DesignacionTribunal designacionTribunal) {
        return designacionTribunalRepository.save(designacionTribunal);
    }

    @Override
    public Optional<DesignacionTribunal> obtenerDesignacionPorId(Integer id) {
        return designacionTribunalRepository.findById(id);
    }

    @Override
    public List<DesignacionTribunal> obtenerTodasLasDesignaciones() {
        return designacionTribunalRepository.findAll();
    }

    @Override
    public DesignacionTribunal actualizarDesignacion(Integer id, DesignacionTribunal designacionTribunal) {
        if (designacionTribunalRepository.existsById(id)) {
            designacionTribunal.setId(id);
            return designacionTribunalRepository.save(designacionTribunal);
        }
        return null;
    }

    @Override
    public void eliminarDesignacion(Integer id) {
        if (designacionTribunalRepository.existsById(id)) {
            designacionTribunalRepository.deleteById(id);
        } else {
            throw new RuntimeException("La designación con ID " + id + " no existe.");
        }
    }

    
}
