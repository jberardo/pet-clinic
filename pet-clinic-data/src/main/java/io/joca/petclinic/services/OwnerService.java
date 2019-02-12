package io.joca.petclinic.services;

import io.joca.petclinic.models.Owner;

/**
 * 
 * @author Joao Berardo
 * @since Feb 07 2019
 *
 */
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastname);
}