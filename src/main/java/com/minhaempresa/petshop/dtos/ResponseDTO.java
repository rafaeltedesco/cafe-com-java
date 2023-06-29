package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.enums.PetKind;

public record ResponseDTO(String nickname, PetKind kind) {

    public ResponseDTO(Pet pet) {
        this(pet.getNickname(), pet.getKind());
    }
}
