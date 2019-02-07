package io.joca.petclinicdata.services;

import java.util.Set;

import io.joca.petclinicdata.models.Pet;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}