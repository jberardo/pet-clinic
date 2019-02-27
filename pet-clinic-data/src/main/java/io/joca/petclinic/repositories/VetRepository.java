package io.joca.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import io.joca.petclinic.models.Vet;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface VetRepository extends CrudRepository<Vet, Long> {
}