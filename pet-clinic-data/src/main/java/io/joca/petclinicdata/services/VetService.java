package io.joca.petclinicdata.services;

import java.util.Set;

import io.joca.petclinicdata.models.Vet;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}