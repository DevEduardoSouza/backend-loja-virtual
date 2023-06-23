package com.aula.backend.service;


import com.aula.backend.entity.Categoria;
import com.aula.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

//   Buscar todas as categorias
    public List<Categoria> bucarTodas(){
        return categoriaRepository.findAll();
    }

//   Cadastrar um nova categoria
    public Categoria inserir(Categoria categoria){
       categoria.setDataCriacao(new Date());
       Categoria categoriaNew = categoriaRepository.saveAndFlush(categoria);
       return  categoriaNew;
    }
//   Alterar uma categoria
    public Categoria alterar(Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }
//   Deletar uma categoria
    public void excluir(Long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }
}
