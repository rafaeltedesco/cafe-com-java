package com.estudojava.petshopapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudojava.petshopapi.models.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
  
}
