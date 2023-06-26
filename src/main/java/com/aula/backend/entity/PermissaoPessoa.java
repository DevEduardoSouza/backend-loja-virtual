package com.aula.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "permissao_pessoa")
@Data
public class PermissaoPessoa extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "IdPessoa")
    @JsonIgnore
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "idPermissao")
    private PermissaoPessoa permissaoPessoa;
}
