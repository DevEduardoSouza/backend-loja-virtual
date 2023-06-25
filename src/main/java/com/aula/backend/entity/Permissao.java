package com.aula.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "permissao")
@Data
public class Permissao  extends AbstractEntity{
}
