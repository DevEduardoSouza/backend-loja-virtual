package com.aula.backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produto_imagens")
@Data
public class ProdutoImagens extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;
}
