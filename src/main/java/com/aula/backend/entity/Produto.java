package com.aula.backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="produto")
@Data
public class Produto extends AbstractEntity{
    private String descricaoCurta;
    private String descricaoDetalhada;
    private Double valorCusto;
    private Double valorVenda;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
}
