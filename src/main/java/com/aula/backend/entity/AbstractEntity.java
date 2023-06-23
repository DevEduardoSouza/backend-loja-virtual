package com.aula.backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Temporal(TemporalType.TIMESTAMP) //Informar que vai ser salvo data e hora
    private Date DataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataAtualizacao;
}
