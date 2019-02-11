package io.joca.petclinic.data.repositories;

import org.springframework.data.repository.CrudRepository;

import io.joca.petclinic.data.models.PetType;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}