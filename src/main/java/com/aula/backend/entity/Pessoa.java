package com.aula.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoa")
public class Pessoa extends AbstractEntity{
    @CPF
    private String cpf;
    @Email
    private String email;
    private String endereco;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "idCidade")
    private Cidade cidade;
}
