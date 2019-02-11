package io.joca.petclinic.data.repositories;

import org.springframework.data.repository.CrudRepository;

import io.joca.petclinic.data.models.Vet;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface VetRepository extends CrudRepository<Vet, Long> {
}