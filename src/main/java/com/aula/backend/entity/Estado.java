package com.aula.backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Estados")
@Data
public class Estado extends AbstractEntity{
    private String nome;
    private String sigla;

}
