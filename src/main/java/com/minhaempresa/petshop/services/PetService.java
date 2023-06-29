package com.minhaempresa.petshop.services;

import com.minhaempresa.petshop.dtos.PetBuilderDto;
import com.minhaempresa.petshop.dtos.PetPayloadDTO;
import com.minhaempresa.petshop.dtos.PetResponseClassDTO;
import com.minhaempresa.petshop.dtos.PetResponseDTO;
import com.minhaempresa.petshop.entities.Owner;
import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.exceptions.throwables.ThrowableFactory;
import com.minhaempresa.petshop.repositories.OwnerRepository;
import com.minhaempresa.petshop.repositories.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PetResponseClassDTO create(PetPayloadDTO petDto) {
        Pet newPet = this.petRepository.save(new Pet(petDto));
        return this.modelMapper.map(newPet, PetResponseClassDTO.class);
    }

    public List<PetBuilderDto> findAll() {
        List<Pet> pets = this.petRepository.findAll();
        return pets.stream()
                .map(pet -> {
                    PetBuilderDto.Builder builder = new PetBuilderDto.Builder();
                    builder.setId(pet.getId()).setNickname(pet.getNickname()).setPetKind(pet.getKind())
                            .setOwner(pet.getOwner());
                    return builder.build();
                })
                .toList();
    }

    public PetResponseDTO findById(Long id) {
        Pet pet = this.petRepository.findById(id)
                .orElseThrow(() -> ThrowableFactory.createNotFoundException(Pet.class, id));
        return PetResponseDTO.fromEntity(pet);
    }

    public PetResponseDTO registerOwner(Long id, Long ownerId) {
        Optional<Owner> owner = this.ownerRepository.findById(ownerId);
        if (owner.isEmpty()) {
            throw ThrowableFactory.createNotFoundException(Owner.class, ownerId);
        }
        Pet pet = this.petRepository.findById(id)
                .orElseThrow(()-> ThrowableFactory.createNotFoundException(Pet.class, id));
        pet.setOwner(owner.get());
        this.petRepository.save(pet);
        return PetResponseDTO.fromEntity(pet);
    }
}
