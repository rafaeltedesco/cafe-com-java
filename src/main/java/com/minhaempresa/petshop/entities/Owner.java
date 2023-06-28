package com.minhaempresa.petshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minhaempresa.petshop.dtos.OwnerPayloadDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "owners")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private Set<Pet> pet;

    private Owner(OwnerPayloadDTO ownerDto) {
        this.name = ownerDto.name();
        this.email = ownerDto.email();
    }
    public static Owner fromDTO(OwnerPayloadDTO ownerDto) {
        return new Owner(ownerDto);
    }
}
