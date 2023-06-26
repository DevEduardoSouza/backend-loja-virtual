package com.aula.backend.controller;

import com.aula.backend.dto.PessoaClienteRequestDTO;
import com.aula.backend.entity.Pessoa;
import com.aula.backend.service.PessoaClienteService;
import com.aula.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {
    @Autowired
    private PessoaClienteService pessoaClienteService;


    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaDto){
        return  pessoaClienteService.registar(pessoaDto);
    }


}
