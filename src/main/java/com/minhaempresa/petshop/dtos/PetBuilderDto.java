package com.minhaempresa.petshop.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.minhaempresa.petshop.entities.Owner;
import com.minhaempresa.petshop.enums.PetKind;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
@Getter @ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PetBuilderDto {

    private Long id;
    private String nickname;
    private PetKind kind;

    private String owner;
    private String ownerEmail;

    public PetBuilderDto(Builder builder) {
        this.id = builder.id;
        this.kind = builder.kind;
        this.nickname = builder.nickname;
        this.owner = builder.owner.getName();
        this.ownerEmail = builder.owner.getEmail();
    }
    public static class Builder {
        private Long id;
        private String nickname;
        private PetKind kind;

        private Owner owner;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder setPetKind(PetKind kind) {
            this.kind = kind;
            return this;
        }

        public Builder setOwner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public PetBuilderDto build() {
            return new PetBuilderDto(this);
        }


    }
}
