package com.sgd.sgdfback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "concurso_doc_interinos")
public class ConcursoDocentesInterinos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private Long cif;

    private String d_solicitud;
    private String d_respaldo;
    private String d_nota_vic;
    private String d_informe_conv;
    private String d_informe_obs;

    private String c_nota_vic;
    private String c_informe_conv;
    private String c_informe_obs;

    @ManyToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;
}
