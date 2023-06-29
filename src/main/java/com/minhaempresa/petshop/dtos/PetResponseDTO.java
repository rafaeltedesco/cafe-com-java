package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.entities.Owner;
import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.enums.PetKind;

public record PetResponseDTO(Long id, String nickname, PetKind kind, OwnerResponseDTO owner) {

    public static PetResponseDTO fromEntity(Pet pet) {
        return new PetResponseDTO(pet.getId(), pet.getNickname(), pet.getKind(), OwnerResponseDTO.fromEntity(pet.getOwner()));
    }

    public PetResponseDTO(Pet pet) {
        this(pet.getId(), pet.getNickname(), pet.getKind(), OwnerResponseDTO.fromEntity(pet.getOwner()));
    }

}
