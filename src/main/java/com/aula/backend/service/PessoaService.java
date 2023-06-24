package com.aula.backend.service;

import com.aula.backend.entity.Cidade;
import com.aula.backend.entity.Pessoa;
import com.aula.backend.repository.CidadeRepository;
import com.aula.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> buscarTodos(){
        return  pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa){
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNovo;
    }
    public Pessoa alterar(Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }
    public void excluir (Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
}
