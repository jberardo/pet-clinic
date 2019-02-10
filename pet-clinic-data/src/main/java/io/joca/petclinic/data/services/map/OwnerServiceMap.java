package io.joca.petclinic.data.services.map;

import java.util.Set;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.Owner;
import io.joca.petclinic.data.models.Pet;
import io.joca.petclinic.data.services.OwnerService;
import io.joca.petclinic.data.services.PetService;
import io.joca.petclinic.data.services.PetTypeService;

/**
 * Created by Joao Berardo on Feb 07 2019
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;
	
    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

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
    	
    	if (owner != null) {
    		if (owner.getPets() != null) {
    			
    			owner.getPets().forEach(pet -> {
    				if (pet.getPetType() != null) {
    					
    					if (pet.getPetType() == null) {
    						pet.setPetType(petTypeService.save(pet.getPetType()));
    					}
    					
    				} else {
    					throw new RuntimeException("Pet Type is required");
    				}
    				
    				if (pet.getId() == null) {
    					Pet savedPet = petService.save(pet);
    					pet.setId(savedPet.getId());
    				}
    			});
    		}
    	}
    	
        return super.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

	@Override
	public Owner findByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}
}