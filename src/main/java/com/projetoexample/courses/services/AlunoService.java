package com.projetoexample.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoexample.courses.entities.Aluno;
import com.projetoexample.courses.repositories.AlunoRepository;
import com.projetoexample.courses.exceptions.NotFoundException;

@Service
public class AlunoService {

  @Autowired
  private AlunoRepository alunoRepository;

  public Aluno findById(Long id) {
    return this.alunoRepository.findById(id).orElseThrow(()-> 
    new NotFoundException(Aluno.class.getSimpleName(), id));
  }
}
