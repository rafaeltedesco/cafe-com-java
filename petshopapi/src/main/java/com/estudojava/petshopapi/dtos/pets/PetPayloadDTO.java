package com.estudojava.petshopapi.dtos.pets;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record PetPayloadDTO(
  @NotBlank @Length(min=3, message="must have at least {min} characters") String name
  ) {
  
}
