package com.aula.backend.controller;

import com.aula.backend.entity.Pessoa;
import com.aula.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> bucarTodas(){
        return pessoaService.buscarTodos();
    }

    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa pessoa){
        return  pessoaService.inserir(pessoa);
    }

    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa pessoa){
        return pessoaService.alterar(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
