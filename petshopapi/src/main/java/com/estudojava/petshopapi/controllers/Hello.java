package com.estudojava.petshopapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudojava.petshopapi.dtos.ResponseDTO;

@RestController
@RequestMapping("hello")
public class Hello {
  
  @GetMapping
  public ResponseDTO sayHello() {
    return new ResponseDTO("Hello World", 200);
  }
}
