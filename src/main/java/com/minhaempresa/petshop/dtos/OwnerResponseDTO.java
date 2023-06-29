package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.entities.Owner;
import com.minhaempresa.petshop.entities.Pet;

import java.util.List;
import java.util.Set;

public record OwnerResponseDTO(Long id, String name, String email, List<ResponseDTO> pet) {

    public static OwnerResponseDTO fromEntity(Owner owner) {
        System.out.println(owner);
        return new OwnerResponseDTO(owner.getId(), owner.getName(), owner.getEmail(), owner.getPet().stream().map(ResponseDTO::new ).toList());
    }

}
