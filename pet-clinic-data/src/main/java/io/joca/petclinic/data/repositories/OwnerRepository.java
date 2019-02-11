package io.joca.petclinic.data.repositories;

import org.springframework.data.repository.CrudRepository;

import io.joca.petclinic.data.models.Owner;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Owner findByLastname(String lastName);
}