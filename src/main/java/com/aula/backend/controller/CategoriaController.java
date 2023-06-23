package com.aula.backend.controller;


import com.aula.backend.entity.Categoria;
import com.aula.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> bucarTodas(){
        return categoriaService.bucarTodas();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria){
        return categoriaService.inserir(categoria);
    }
    @PutMapping("/")
    public Categoria alterar(@RequestBody Categoria categoria){
        return categoriaService.alterar(categoria);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id")Long id){
        categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
