package io.joca.petclinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.Vet;
import io.joca.petclinic.data.services.VetService;

/**
 * Created by Joao Berardo on Feb 07 2019
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
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
        return super.save(vet);
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