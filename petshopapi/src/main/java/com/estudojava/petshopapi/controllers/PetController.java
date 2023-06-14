package com.estudojava.petshopapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.estudojava.petshopapi.dtos.exceptions.ExceptionDTO;
import com.estudojava.petshopapi.dtos.pets.PetPayloadDTO;
import com.estudojava.petshopapi.dtos.pets.PetResponseDTO;
import com.estudojava.petshopapi.models.Pet;
import com.estudojava.petshopapi.repositories.PetRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pets")
public class PetController {
  
  @Autowired
  private PetRepository petRepository;

  @GetMapping
  public List<Pet> findAll() {
    return this.petRepository.findAll();
  }

  @GetMapping("{id}")
  public PetResponseDTO findById(@PathVariable Long id) {
    Pet pet = this.petRepository.findById(id)
      .orElseThrow();
    return PetResponseDTO.fromEntity(pet);
  }

  @PostMapping
  public PetResponseDTO create(@Valid @RequestBody PetPayloadDTO pet) {
    Pet newPet = this.petRepository.save(new Pet(pet));
    return PetResponseDTO.fromEntity(newPet);
  }

}
