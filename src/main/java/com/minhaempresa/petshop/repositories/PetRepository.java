package com.minhaempresa.petshop.repositories;

import com.minhaempresa.petshop.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
