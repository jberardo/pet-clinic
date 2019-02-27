package io.joca.petclinic.services.map;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import io.joca.petclinic.models.Owner;
import io.joca.petclinic.models.Pet;
import io.joca.petclinic.services.OwnerService;
import io.joca.petclinic.services.PetService;
import io.joca.petclinic.services.PetTypeService;

/**
 * 
 * @author Joao Berardo
 * @since Feb 07 2019
 *
 */
@Service
@Profile({ "default", "map" })
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

		if (owner != null && owner.getPets() != null) {
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
		return this.findAll()
				.stream()
				.filter(o -> o.getLastname().equalsIgnoreCase(lastname))
				.findFirst()
				.orElse(null);
	}
	
    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        //TODO - implement findAllByLastNameLike in OwnerServiceMap
        return null;
    }
}