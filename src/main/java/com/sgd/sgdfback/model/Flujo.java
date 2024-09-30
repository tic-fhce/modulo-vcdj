package com.sgd.sgdfback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flujo")
public class Flujo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flujo;
    private String proceso;
    private String proceso_sig;
    private String formulario;
    private Integer tiempo;
    

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Rol role;

    @OneToMany(mappedBy = "flujo")
    private List<ProcesoCondicion> procesos_cond;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
