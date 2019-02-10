package io.joca.petclinic.data.models;

import java.util.Set;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class Vet extends Person {
    
	private Set<Specialty> specialties;

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
}