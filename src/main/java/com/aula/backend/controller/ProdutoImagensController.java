package com.aula.backend.controller;


import com.aula.backend.entity.Categoria;
import com.aula.backend.entity.ProdutoImagens;
import com.aula.backend.service.CategoriaService;
import com.aula.backend.service.ProdutoImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/produtoImagens")
@CrossOrigin(origins = "*")
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService produtoImagensService;

    @GetMapping("/")
    public List<ProdutoImagens> bucarTodas(){
        return produtoImagensService.bucarTodos();
    }

    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file){
        return produtoImagensService.inserir(idProduto, file);
    }
    @PutMapping("/")
    public ProdutoImagens alterar(@RequestBody ProdutoImagens produtoImagens){
        return produtoImagensService.alterar(produtoImagens);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id")Long id){
        produtoImagensService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
