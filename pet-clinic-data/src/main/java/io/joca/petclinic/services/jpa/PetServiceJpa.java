package io.joca.petclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import io.joca.petclinic.models.Pet;
import io.joca.petclinic.repositories.PetRepository;
import io.joca.petclinic.services.PetService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Joao Berardo
 * @since Feb 11 2019
 *
 */
@Slf4j
@Service
@Profile("jpa")
public class PetServiceJpa implements PetService {

	private final PetRepository petRepository;

	public PetServiceJpa(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().iterator().forEachRemaining(pets::add);
		
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet pet) {
		return petRepository.save(pet);
	}

	@Override
	public void delete(Pet pet) {
		petRepository.delete(pet);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}
}