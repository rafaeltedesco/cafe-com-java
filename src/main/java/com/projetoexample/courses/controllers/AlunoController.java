package com.projetoexample.courses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoexample.courses.entities.Aluno;
import com.projetoexample.courses.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoService alunoService;
  
  @GetMapping("/{id}")
  public Aluno findById(@PathVariable Long id) {
    return this.alunoService.findById(id);
  }

}
