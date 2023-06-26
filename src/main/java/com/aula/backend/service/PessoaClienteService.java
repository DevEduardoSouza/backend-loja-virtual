package com.aula.backend.service;

import com.aula.backend.dto.PessoaClienteRequestDTO;
import com.aula.backend.entity.Pessoa;
import com.aula.backend.repository.PermissaoRepository;
import com.aula.backend.repository.PessoaClienteRepository;
import com.aula.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaClienteService {
    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;


    public Pessoa registar(PessoaClienteRequestDTO pessoaDto){
        Pessoa pessoa = new PessoaClienteRequestDTO().coverter(pessoaDto);

        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);

        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNovo);
        return pessoaNovo;
    }

}
