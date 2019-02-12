package io.joca.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.joca.petclinic.models.Pet;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}