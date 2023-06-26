package com.aula.backend.service;


import com.aula.backend.entity.Permissao;
import com.aula.backend.entity.PermissaoPessoa;
import com.aula.backend.entity.Pessoa;
import com.aula.backend.repository.PermissaoPessoaRepository;
import com.aula.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;


    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissaoCliente(Pessoa pessoa){
        List<Permissao>  listaPermisssao = permissaoRepository.findByNome("cliente");
        if(listaPermisssao.size() > 0){
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermisssao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }


    }

}
