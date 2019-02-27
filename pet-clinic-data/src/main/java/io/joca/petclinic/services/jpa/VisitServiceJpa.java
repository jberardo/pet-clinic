package io.joca.petclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import io.joca.petclinic.models.Visit;
import io.joca.petclinic.repositories.VisitRepository;
import io.joca.petclinic.services.VisitService;

/**
 * 
 * @author Joao Berardo
 * @since Feb 11 2019
 *
 */
@Service
@Profile("jpa")
public class VisitServiceJpa implements VisitService {

	private final VisitRepository visitRepository;
	
	public VisitServiceJpa(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().iterator().forEachRemaining(visits::add);
		
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit visit) {
		return visitRepository.save(visit);
	}

	@Override
	public void delete(Visit visit) {
		visitRepository.delete(visit);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
}