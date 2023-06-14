package com.estudojava.petshopapi.dtos.pets;

import com.estudojava.petshopapi.models.Pet;

public record PetResponseDTO(Long id, String name) {
  
  public static PetResponseDTO fromEntity(Pet pet) {
    return new PetResponseDTO(pet.getId(), pet.getName());
  }
}
