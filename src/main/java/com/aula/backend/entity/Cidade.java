package com.aula.backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cidade")
@Data
public class Cidade extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idEstado")
    private Estado estado;
}
