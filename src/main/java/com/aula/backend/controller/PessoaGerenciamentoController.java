package com.aula.backend.controller;

import com.aula.backend.dto.PessoaClienteRequestDTO;
import com.aula.backend.entity.Pessoa;
import com.aula.backend.service.PessoaClienteService;
import com.aula.backend.service.PessoaGerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {
    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;
    @PostMapping("/")
    public String recuperarCodigo(@RequestParam("email") String email){
        return pessoaGerenciamentoService.solicitarCodigo(email);
    }


}
