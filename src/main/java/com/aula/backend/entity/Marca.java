package com.aula.backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Marca")
@Data
public class Marca extends AbstractEntity{
}
