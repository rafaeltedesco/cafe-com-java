package com.minhaempresa.petshop.controllers;

import com.minhaempresa.petshop.dtos.PetPayloadDTO;
import com.minhaempresa.petshop.dtos.PetResponseDTO;
import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.repositories.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @PostMapping
    public PetResponseDTO create(@RequestBody PetPayloadDTO petDto) {
        Pet newPet = this.petRepository.save(new Pet(petDto));
        return PetResponseDTO.fromEntity(newPet);
    }

    @GetMapping
    public List<PetResponseDTO> findAll() {
        List<Pet> pets = this.petRepository.findAll();
        List<PetResponseDTO> response = pets.stream()
                .map(PetResponseDTO::fromEntity)
                .toList();
        return response;
    }
    @GetMapping("{id}")
    public PetResponseDTO findById(@PathVariable Long id) {
        Pet pet = this.petRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(
                        String.format("Pet with id %d not found %s", id, "teste")));
        return PetResponseDTO.fromEntity(pet);
    }
}
