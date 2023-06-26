package com.aula.backend.controller;

import com.aula.backend.dto.PessoaClienteRequestDTO;
import com.aula.backend.entity.Pessoa;
import com.aula.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {
    @Autowired
    private PessoaService pessoaService;


    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaDto){
        Pessoa pessoa = new PessoaClienteRequestDTO().coverter(pessoaDto);
        return  pessoaService.inserir(pessoa);
    }


}
