package io.joca.petclinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.Pet;
import io.joca.petclinic.data.services.CrudService;

/**
 * Created by Joao Berardo on Feb 07 2019
 */
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}