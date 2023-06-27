package com.aula.backend.service;

import com.aula.backend.dto.PessoaClienteRequestDTO;
import com.aula.backend.entity.Pessoa;
import com.aula.backend.repository.PessoaClienteRepository;
import com.aula.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PessoaGerenciamentoService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;


    public String solicitarCodigo(String email){
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());

        pessoaRepository.saveAndFlush(pessoa);


        emailService.enviarEmalTexto(pessoa.getEmail(), "Código de Reuperação de senha ",
                "O seu código para recuperação de senha é: " + pessoa.getCodigoRecuperacaoSenha());
        return "Código enviado";
    }

    private String getCodigoRecuperacaoSenha(Long id){
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");

        return format.format(new Date()) + id;
    }

}
