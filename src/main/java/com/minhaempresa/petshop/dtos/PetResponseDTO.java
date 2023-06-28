package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.entities.Owner;
import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.enums.PetKind;

public record PetResponseDTO(Long id, String nickname, PetKind kind) {

    public static PetResponseDTO fromEntity(Pet pet) {
        return new PetResponseDTO(pet.getId(), pet.getNickname(), pet.getKind());
    }

    public PetResponseDTO(Pet pet) {
        this(pet.getId(), pet.getNickname(), pet.getKind());
    }

}
