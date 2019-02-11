package io.joca.petclinic.data.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.Owner;
import io.joca.petclinic.data.repositories.OwnerRepository;
import io.joca.petclinic.data.services.OwnerService;

@Service
@Profile("jpa")
public class OwnerServiceJpa implements OwnerService {

	private final OwnerRepository ownerRepository;
	
	public OwnerServiceJpa(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		
		Set<Owner> owners = new HashSet<Owner>();
		ownerRepository.findAll().iterator().forEachRemaining(owners::add);
		
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Owner owner) {
		ownerRepository.delete(owner);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastname) {
		return ownerRepository.findByLastname(lastname);
	}
}
