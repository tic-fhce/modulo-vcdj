package com.sgd.sgdfback.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(nullable = false)
    private String username;
    private String password;
    private String cif;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Seguimiento> seguimientos;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<UsuarioRol> user_roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UsuarioRol userRole : user_roles) {
            String roleName = userRole.getRole().getName().toString(); // Obtener el nombre del rol
            authorities.add(new SimpleGrantedAuthority(roleName));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    public Usuario() {
    }

    public Usuario(Integer id, String username, String password, String cif, List<Seguimiento> seguimientos, List<UsuarioRol> user_roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cif = cif;
        this.seguimientos = seguimientos;
        this.user_roles = user_roles;
    }

    private Usuario(builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.cif = builder.cif;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCif() {
        return this.cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public List<Seguimiento> getSeguimientos() {
        return this.seguimientos;
    }

    public void setSeguimientos(List<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }

    public List<UsuarioRol> getUser_roles() {
        return this.user_roles;
    }

    public void setUser_roles(List<UsuarioRol> user_roles) {
        this.user_roles = user_roles;
    }

    public static class builder {
        private Integer id;
        private String username;
        private String password;
        private String cif;

        public builder id(Integer id) {
            this.id = id;
            return this;
        }

        public builder username(String username) {
            this.username = username;
            return this;
        }

        public builder password(String password) {
            this.password = password;
            return this;
        }

        public builder cif(String cif) {
            this.cif = cif;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

}

