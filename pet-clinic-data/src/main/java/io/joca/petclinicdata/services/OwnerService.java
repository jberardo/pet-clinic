package io.joca.petclinicdata.services;

import io.joca.petclinicdata.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastname);
}