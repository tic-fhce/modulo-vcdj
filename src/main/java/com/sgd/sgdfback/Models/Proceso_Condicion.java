package com.sgd.sgdfback.Models;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "procesocond")
public class Proceso_Condicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flujo;
    private String proceso;
    private String si;
    private String no;

    @ManyToOne
    @JoinColumn(name = "flujo_id")
    private Flujo flujo2;

}
