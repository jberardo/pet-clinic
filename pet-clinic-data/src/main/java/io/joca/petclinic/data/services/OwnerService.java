package io.joca.petclinic.data.services;

import io.joca.petclinic.data.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastname);
}