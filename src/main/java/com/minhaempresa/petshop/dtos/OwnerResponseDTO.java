package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.entities.Owner;
import com.minhaempresa.petshop.entities.Pet;

import java.util.Set;

public record OwnerResponseDTO(Long id, String name, String email, Set<Pet> pet) {

    public static OwnerResponseDTO fromEntity(Owner owner) {
        return new OwnerResponseDTO(owner.getId(), owner.getName(), owner.getEmail(), owner.getPet());
    }

}
