package io.joca.petclinic.data.repositories;

import org.springframework.data.repository.CrudRepository;

import io.joca.petclinic.data.models.Visit;

/**
 * 
 * @author Joao Berardo
 * @since Feb 10 2019
 *
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}