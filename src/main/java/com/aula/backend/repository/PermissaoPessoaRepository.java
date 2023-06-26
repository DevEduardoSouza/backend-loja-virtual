package com.aula.backend.repository;

import com.aula.backend.entity.Permissao;
import com.aula.backend.entity.PermissaoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa, Long> {

}
