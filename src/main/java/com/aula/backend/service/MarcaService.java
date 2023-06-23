package com.aula.backend.service;


import com.aula.backend.entity.Marca;
import com.aula.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    //Listar todos as marcas
    public List<Marca> buscarTodas(){
        return marcaRepository.findAll();
    }

    //Inserir um marca
    public Marca inserir(Marca marca){
        marca.setDataCriacao(new Date());
        Marca marcaNew = marcaRepository.saveAndFlush(marca);
        return marcaNew;
    }

    //Atualizar marca
    public Marca alterar(Marca marca){
        marca.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    //Excluir uma marca
    public void excluir(Long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}
