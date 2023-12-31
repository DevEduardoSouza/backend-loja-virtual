package com.aula.backend.controller;


import com.aula.backend.entity.Cidade;
import com.aula.backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@CrossOrigin(origins = "*")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodos(){
        return cidadeService.buscarTodos();
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade cidade){
        return cidadeService.inserir(cidade);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade cidade){
        return cidadeService.alterar(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
