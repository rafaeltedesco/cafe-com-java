package com.projetoexample.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoexample.courses.dtos.CEPDto;
import com.projetoexample.courses.entities.Aluno;
import com.projetoexample.courses.helpers.ConsultaAPICEP;
import com.projetoexample.courses.repositories.AlunoRepository;

@Service
public class AlunoService {

  @Autowired
  private AlunoRepository alunoRepository;

  @Autowired
  private ConsultaAPICEP consultaAPICEP;

  public Aluno findById(Long id) {
    CEPDto cepDto = consultaAPICEP.fetch("01001-000");
    System.out.println("Location :" + cepDto.getLocalidade());
    return this.alunoRepository.findById(id).orElseThrow();
  }
}
