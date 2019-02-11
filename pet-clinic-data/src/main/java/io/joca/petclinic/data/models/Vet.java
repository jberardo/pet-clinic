package io.joca.petclinic.data.models;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Joao Berardo
 * @since Feb 06 2019
 *
 */
public class Vet extends Person {
    
	private Set<Specialty> specialties = new HashSet<>();

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
}