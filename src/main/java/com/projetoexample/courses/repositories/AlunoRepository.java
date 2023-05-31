package com.projetoexample.courses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoexample.courses.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
  
}
