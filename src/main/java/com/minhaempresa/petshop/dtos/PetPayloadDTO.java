package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.enums.PetKind;

public record PetPayloadDTO(String nickname, PetKind kind) {
}
