package io.joca.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import io.joca.petclinic.models.Specialty;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}