package com.minhaempresa.petshop.entities;

import com.minhaempresa.petshop.dtos.PetPayloadDTO;
import com.minhaempresa.petshop.enums.PetKind;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private PetKind kind;
    public Pet(PetPayloadDTO petDTO) {
        this.nickname = petDTO.nickname();
        this.kind = petDTO.kind();
    }
}
