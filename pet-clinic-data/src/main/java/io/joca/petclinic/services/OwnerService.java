package io.joca.petclinic.services;

import java.util.List;

import io.joca.petclinic.models.Owner;

/**
 * 
 * @author Joao Berardo
 * @since Feb 07 2019
 *
 */
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastname);
    List<Owner> findAllByLastNameLike(String lastName);
}