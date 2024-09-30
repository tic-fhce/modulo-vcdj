package com.sgd.sgdfback.service;

import com.sgd.sgdfback.model.MateriaExtra;

import java.util.List;
import java.util.Optional;

public interface MateriaExtraService {
    void actualizarColumna(String columna, String param, String nroTramite);
    String obtenerColumna(String nroTramite, String columna);

    // Métodos CRUD
    MateriaExtra crearMateriaExtra(MateriaExtra materiaExtra);
    Optional<MateriaExtra> obtenerMateriaExtraPorId(Integer id);
    List<MateriaExtra> obtenerTodasLasMateriasExtras();
    MateriaExtra actualizarMateriaExtra(Integer id, MateriaExtra materiaExtra);
    void eliminarMateriaExtra(Integer id);
}
