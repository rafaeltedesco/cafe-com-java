package com.projetoexample.courses.helpers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.projetoexample.courses.dtos.CEPDto;

@Component
public class ConsultaAPICEP {
  
  private String buildUrl(String cep) {
    return "https://viacep.com.br/ws/" + cep + "/json/";
  }

  private RestTemplate restTemplate;

  ConsultaAPICEP() {
    this.restTemplate = new RestTemplate();
  }

  public CEPDto fetch(String cep) {
    ResponseEntity<CEPDto> response = this.restTemplate.getForEntity(buildUrl(cep), CEPDto.class);
    CEPDto dto = response.getBody();
    return dto;
  }

}
