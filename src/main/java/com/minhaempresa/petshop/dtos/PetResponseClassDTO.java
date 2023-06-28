package com.minhaempresa.petshop.dtos;

import com.minhaempresa.petshop.enums.PetKind;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class PetResponseClassDTO {

    private Long id;
    private String nickname;
    private PetKind kind;
}
