package com.minhaempresa.petshop.services;

import com.minhaempresa.petshop.dtos.PetPayloadDTO;
import com.minhaempresa.petshop.dtos.PetResponseDTO;
import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.exceptions.throwables.ThrowableFactory;
import com.minhaempresa.petshop.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetResponseDTO create(PetPayloadDTO petDto) {
        Pet newPet = this.petRepository.save(new Pet(petDto));
        return PetResponseDTO.fromEntity(newPet);
    }

    public List<PetResponseDTO> findAll() {
        List<Pet> pets = this.petRepository.findAll();
        return pets.stream()
                .map(PetResponseDTO::fromEntity)
                .toList();
    }

    public PetResponseDTO findById(Long id) {
        Pet pet = this.petRepository.findById(id)
                .orElseThrow(() -> ThrowableFactory.createNotFoundException(Pet.class, id));
        return PetResponseDTO.fromEntity(pet);
    }
}
