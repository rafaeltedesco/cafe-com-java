package com.minhaempresa.petshop.services;

import com.minhaempresa.petshop.dtos.OwnerPayloadDTO;
import com.minhaempresa.petshop.entities.Owner;
import com.minhaempresa.petshop.exceptions.throwables.ThrowableFactory;
import com.minhaempresa.petshop.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> findAll() {
        return this.ownerRepository.findAll();
    }

    public Owner findById(Long id) {
        return this.ownerRepository.findById(id).orElseThrow(()-> ThrowableFactory.createNotFoundException(Owner.class, id));
    }

    public Owner create(OwnerPayloadDTO ownerDTO) {
        return this.ownerRepository.save(Owner.fromDTO(ownerDTO));
    }
}
