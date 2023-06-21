package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.enums.PetKind;

public record PetResponseDTO(String nickname, PetKind kind) {

    public static PetResponseDTO fromEntity(Pet pet) {
        return new PetResponseDTO(pet.getNickname(), pet.getKind());
    }

    public PetResponseDTO(Pet pet) {
        this(pet.getNickname(), pet.getKind());
    }

}
