package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.enums.PetKind;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record PetPayloadDTO(
        @NotBlank(message = "O campo nickname é necessário")
        @Length(min=3, message="O campo deve ter pelo menos {min} caracterecers")
        String nickname,
        PetKind kind) {
}
