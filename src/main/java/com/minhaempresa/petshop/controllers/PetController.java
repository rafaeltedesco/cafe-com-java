package com.minhaempresa.petshop.controllers;

import com.minhaempresa.petshop.dtos.*;
import com.minhaempresa.petshop.entities.Pet;
import com.minhaempresa.petshop.services.PetService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PetResponseClassDTO create(@RequestBody PetPayloadDTO petDto) {
        return this.petService.create(petDto);
    }
    @GetMapping
    public List<PetBuilderDto> findAll() {
       return this.petService.findAll();
    }
    @GetMapping("{id}")
    public PetResponseDTO findById(@PathVariable Long id) {
        return this.petService.findById(id);
    }

    @PatchMapping("{id}")
    public PetResponseDTO registerOwner(@PathVariable Long id, @RequestBody RegisterOwnerPayloadDTO ownerDto) {
        return this.petService.registerOwner(id, ownerDto.ownerId());
    }
}
