package com.aula.backend.repository;

import com.aula.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
}
