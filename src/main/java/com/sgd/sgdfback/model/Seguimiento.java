package com.sgd.sgdfback.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seguimiento")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private String estado;
    private String comentario;
    @Column(columnDefinition = "VARCHAR(6) DEFAULT 'false'")
    private String visto;
    private LocalDateTime tiempo;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    @ManyToOne
    @JoinColumn(name = "usuarioRol_id")
    private UsuarioRol usuarioRol;

    @ManyToOne
    @JoinColumn(name = "flujo_id")
    private Flujo flujo;


    public Seguimiento() {
    }


    public Seguimiento(Integer id, LocalDateTime fecha_inicio, LocalDateTime fecha_fin, String estado, String comentario, String visto, LocalDateTime tiempo, Tramite tramite, UsuarioRol usuarioRol, Flujo flujo) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.comentario = comentario;
        this.visto = visto;
        this.tiempo = tiempo;
        this.tramite = tramite;
        this.usuarioRol = usuarioRol;
        this.flujo = flujo;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha_inicio() {
        return this.fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return this.fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getVisto() {
        return this.visto;
    }

    public void setVisto(String visto) {
        this.visto = visto;
    }

    public LocalDateTime getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public UsuarioRol getUsuarioRol() {
        return this.usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public Flujo getFlujo() {
        return this.flujo;
    }

    public void setFlujo(Flujo flujo) {
        this.flujo = flujo;
    }
    



    
}
