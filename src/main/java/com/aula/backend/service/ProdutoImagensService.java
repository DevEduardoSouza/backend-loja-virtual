package com.aula.backend.service;


import com.aula.backend.entity.Categoria;
import com.aula.backend.entity.ProdutoImagens;
import com.aula.backend.repository.CategoriaRepository;
import com.aula.backend.repository.ProdutoImagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {
    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;


    public List<ProdutoImagens> bucarTodos(){
        return produtoImagensRepository.findAll();
    }


    public ProdutoImagens inserir(ProdutoImagens produtoImagens){
        produtoImagens.setDataCriacao(new Date());
        ProdutoImagens produtoImagensNovo = produtoImagensRepository.saveAndFlush(produtoImagens);
       return  produtoImagensNovo;
    }

    public ProdutoImagens alterar(ProdutoImagens produtoImagens){
        produtoImagens.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public void excluir(Long id){
        ProdutoImagens categoria = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(categoria);
    }
}
