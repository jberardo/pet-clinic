package io.joca.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import io.joca.petclinic.models.Visit;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}