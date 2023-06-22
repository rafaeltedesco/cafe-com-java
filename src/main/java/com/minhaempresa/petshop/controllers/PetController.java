package com.minhaempresa.petshop.controllers;

import com.minhaempresa.petshop.dtos.PetPayloadDTO;
import com.minhaempresa.petshop.dtos.PetResponseDTO;
import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.entities.User;
import com.minhaempresa.petshop.services.PetService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;
import com.minhaempresa.petshop.exceptions.throwables.ThrowableFactory;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public PetResponseDTO create(@Valid @RequestBody PetPayloadDTO petDto) {
        return this.petService.create(petDto);
    }
    @GetMapping
    public User findAll(@AuthenticationPrincipal OidcUser principal) {
        User user = new User.UserBuilder(principal.getEmail())
                .setFullName(principal.getFullName())
                .setBirthdate(principal.getBirthdate())
                .setPhoneNumber(principal.getPhoneNumber())
                .build();
        return user;
//        return this.petService.findAll();
    }
    @GetMapping("{id}")
    public PetResponseDTO findById(@PathVariable Long id) {
        return this.petService.findById(id);
    }

}
