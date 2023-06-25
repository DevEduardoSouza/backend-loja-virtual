package com.aula.backend.repository;


import com.aula.backend.entity.Categoria;
import com.aula.backend.entity.ProdutoImagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
}
