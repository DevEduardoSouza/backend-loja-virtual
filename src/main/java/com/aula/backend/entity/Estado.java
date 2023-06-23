package com.aula.backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Estados")
@Data
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sigla;
    @Temporal(TemporalType.TIMESTAMP) //Informar que vai ser salvo data e hora
    private Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataAtualizacao;

}
