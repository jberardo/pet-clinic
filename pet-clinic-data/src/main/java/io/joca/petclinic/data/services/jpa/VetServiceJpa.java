package io.joca.petclinic.data.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.Vet;
import io.joca.petclinic.data.repositories.VetRepository;
import io.joca.petclinic.data.services.VetService;

/**
 * 
 * @author Joao Berardo
 * @since Feb 11 2019
 *
 */
@Service
@Profile("jpa")
public class VetServiceJpa implements VetService {

	
//	private final VetRepository vetRepository;
//	
//	public VetServiceJpa(VetRepository vetRepository) {
//		super();
//		this.vetRepository = vetRepository;
//	}

	@Override
	public Set<Vet> findAll() {
//		Set<Vet> vets = new HashSet<Vet>();
//		vetRepository.findAll().iterator().forEachRemaining(vets::add);
//		
//		return vets;
		return null;
	}

	@Override
	public Vet findById(Long id) {
		//return vetRepository.findById(id).orElse(null);
		return null;
	}

	@Override
	public Vet save(Vet vet) {
		//return vetRepository.save(vet);
		return null;
	}

	@Override
	public void delete(Vet vet) {
		//vetRepository.delete(vet);
	}

	@Override
	public void deleteById(Long id) {
		//vetRepository.deleteById(id);
	}
}