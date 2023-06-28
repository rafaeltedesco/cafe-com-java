package com.minhaempresa.petshop.repositories;

import com.minhaempresa.petshop.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PetRepository extends JpaRepository<Pet, Long> {
    public List<Pet> findByNicknameContaining(String nickname);

    public Optional<Pet> findByNickname(String nickname);
}
