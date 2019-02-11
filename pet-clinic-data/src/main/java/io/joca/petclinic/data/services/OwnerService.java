package io.joca.petclinic.data.services;

import io.joca.petclinic.data.models.Owner;

/**
 * 
 * @author Joao Berardo
 * @since Feb 07 2019
 *
 */
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastname);
}