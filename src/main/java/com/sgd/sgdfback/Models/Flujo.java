package com.sgd.sgdfback.Models;

import java.util.*;

import javax.persistence.*;

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
    private Role role;

    @OneToMany(mappedBy = "flujo")
    private List<Proceso_Condicion> procesos_cond;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
