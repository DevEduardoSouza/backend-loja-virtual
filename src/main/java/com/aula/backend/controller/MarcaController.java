package com.aula.backend.controller;


import com.aula.backend.entity.Marca;
import com.aula.backend.service.MarcaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@CrossOrigin(origins = "*")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> bucarTodas(){
        return marcaService.buscarTodas();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca){
        return  marcaService.inserir(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca){
        return marcaService.alterar(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
