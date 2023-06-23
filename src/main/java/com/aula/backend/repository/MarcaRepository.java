package com.aula.backend.repository;

import com.aula.backend.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long > {
}
