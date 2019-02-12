package io.joca.petclinic.data.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.PetType;
import io.joca.petclinic.data.services.PetTypeService;

/**
 * 
 * @author Joao Berardo
 * @since Feb 07 2019
 *
 */
@Service
@Profile({ "default", "map" })
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType pet) {
        return super.save(pet);
    }

    @Override
    public void delete(PetType pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}