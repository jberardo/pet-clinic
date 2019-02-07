package io.joca.petclinicdata.services.map;

import java.util.Set;

import io.joca.petclinicdata.models.Vet;
import io.joca.petclinicdata.services.CrudService;

/**
 * Created by Joao Berardo on Feb 07 2019
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}