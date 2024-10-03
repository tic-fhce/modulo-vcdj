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
    private String flujo;
    private String proceso;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private String estado;
    private String comentario;
    private String carrera;
    @Column(columnDefinition = "VARCHAR(6) DEFAULT 'false'")
    private String visto;
    private LocalDateTime tiempo;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Rol role;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;


    public Seguimiento() {
    }

    public Seguimiento(Integer id, String flujo, String proceso, LocalDateTime fecha_inicio, LocalDateTime fecha_fin, String estado, String comentario, String carrera, String visto, LocalDateTime tiempo, Rol role, Tramite tramite, Usuario user) {
        this.id = id;
        this.flujo = flujo;
        this.proceso = proceso;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.comentario = comentario;
        this.carrera = carrera;
        this.visto = visto;
        this.tiempo = tiempo;
        this.role = role;
        this.tramite = tramite;
        this.user = user;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlujo() {
        return this.flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }

    public String getProceso() {
        return this.proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
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

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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

    public Rol getRole() {
        return this.role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }


}
