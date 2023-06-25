package com.aula.backend.service;


import com.aula.backend.entity.Categoria;
import com.aula.backend.entity.Produto;
import com.aula.backend.entity.ProdutoImagens;
import com.aula.backend.repository.CategoriaRepository;
import com.aula.backend.repository.ProdutoImagensRepository;
import com.aula.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {
    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoImagens> bucarTodos(){
        return produtoImagensRepository.findAll();
    }


    public ProdutoImagens inserir(Long idProduto, MultipartFile file){
        ProdutoImagens objeto = new ProdutoImagens();
        Produto produto = produtoRepository.findById(idProduto).get();

        try {

            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();

                Path caminho = Paths.get("c:/imagens/" + nomeImagem);

                Files.write(caminho, bytes);

                objeto.setNome(nomeImagem);
            }
        } catch (IOException e){
            e.printStackTrace();
        }




        objeto.setProduto(produto);
        objeto.setDataCriacao(new Date());
        objeto = produtoImagensRepository.saveAndFlush(objeto);
        return  objeto;
    }

    public ProdutoImagens alterar(ProdutoImagens produtoImagens){
        produtoImagens.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public void excluir(Long id){
        ProdutoImagens categoria = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(categoria);
    }
}
