package com.minhaempresa.petshop.controllers;

import com.minhaempresa.petshop.dtos.OwnerPayloadDTO;
import com.minhaempresa.petshop.dtos.OwnerResponseDTO;
import com.minhaempresa.petshop.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<OwnerResponseDTO> findAll() {
        return this.ownerService.findAll().stream().map(OwnerResponseDTO::fromEntity).toList();
    }

    @GetMapping("{id}")
    public OwnerResponseDTO findById(@PathVariable Long id) {
        return OwnerResponseDTO.fromEntity(this.ownerService.findById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public OwnerResponseDTO create(@RequestBody OwnerPayloadDTO ownerDto) {
        return OwnerResponseDTO.fromEntity(this.ownerService.create(ownerDto));
    }
}
