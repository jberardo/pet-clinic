package io.joca.petclinicdata.services.map;

import java.util.Set;

import io.joca.petclinicdata.models.Owner;
import io.joca.petclinicdata.services.CrudService;

/**
 * Created by Joao Berardo on Feb 07 2019
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}