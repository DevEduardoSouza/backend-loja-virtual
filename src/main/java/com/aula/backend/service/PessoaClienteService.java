package com.aula.backend.service;

import com.aula.backend.dto.PessoaClienteRequestDTO;
import com.aula.backend.entity.Pessoa;
import com.aula.backend.repository.PermissaoRepository;
import com.aula.backend.repository.PessoaClienteRepository;
import com.aula.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PessoaClienteService {
    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;


    public Pessoa registar(PessoaClienteRequestDTO pessoaDto){
        Pessoa pessoa = new PessoaClienteRequestDTO().coverter(pessoaDto);

        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);

        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNovo);

        //emailService.enviarEmalTexto(pessoa.getEmail(), "Cadastro na Loja virtual", "O resisitro na loja foi realizado com sucesso. " +"Em breve você receberá a senha de acesso por e-mail");

        Map<String, Object> proprMap =  new HashMap<>();
        proprMap.put("nome", pessoaNovo.getNome());
        proprMap.put("mensagem", "O regisitro na loja foi realizado com sucesso. Em breve você receberá a senha de acesso por e-mail");

        emailService.enviarEmailTemplate(pessoaNovo.getEmail(), "Cadastro na Loja virtual", proprMap);
        return pessoaNovo;
    }

}
