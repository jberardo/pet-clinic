package io.joca.petclinic.data.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.Specialty;
import io.joca.petclinic.data.repositories.SpecialtyRepository;
import io.joca.petclinic.data.services.SpecialtyService;

@Service
@Profile("jpa")
public class SpecialtyServiceJpa implements SpecialtyService {

	private SpecialtyRepository specialtyRepository;

	public SpecialtyServiceJpa(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		
		Set<Specialty> specialties = new HashSet<>();
		specialtyRepository.findAll().iterator().forEachRemaining(specialties::add);
		
		return specialties;
	}

	@Override
	public Specialty findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Specialty save(Specialty specialty) {
		return specialtyRepository.save(specialty);
	}

	@Override
	public void delete(Specialty specialty) {
		specialtyRepository.delete(specialty);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}
}