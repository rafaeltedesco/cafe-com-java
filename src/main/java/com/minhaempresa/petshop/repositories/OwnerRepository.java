package com.minhaempresa.petshop.repositories;

import com.minhaempresa.petshop.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
