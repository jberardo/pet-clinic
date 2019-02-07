package io.joca.petclinicdata.services;

import java.util.Set;

import io.joca.petclinicdata.models.Owner;

public interface OwnerService {
    Owner findByLastName(String lastname);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}