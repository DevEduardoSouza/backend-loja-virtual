package com.aula.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa extends AbstractEntity{
    @CPF
    private String cpf;
    @Email
    private String email;
    private String endereco;
    private String cep;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;
    @ManyToOne
    @JoinColumn(name = "idCidade")
    private Cidade cidade;


    public void setPermissaoPessoas(List<PermissaoPessoa> pp){
        for (PermissaoPessoa p: pp){
            p.setPessoa(this);
        }

        this.permissaoPessoas = pp;

    }



}
