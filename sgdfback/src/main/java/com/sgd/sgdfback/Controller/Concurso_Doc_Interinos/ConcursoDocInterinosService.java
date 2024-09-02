package com.sgd.sgdfback.Controller.Concurso_Doc_Interinos;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ConcursoDocInterinosService {

    private final ConcursoDocInterinosRepository concursoR;

    public void actualizarColum(String columna, String param, String nroTramite) {
        concursoR.updateColum(columna, param, nroTramite);
    }

    public String obtenerColum(String nroTramite, String columna) {
        return concursoR.obtenerColumna(nroTramite, columna);
    }
}