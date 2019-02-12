package io.joca.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import io.joca.petclinic.models.PetType;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}