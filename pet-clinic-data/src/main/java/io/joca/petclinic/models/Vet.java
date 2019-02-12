package io.joca.petclinic.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Joao Berardo
 * @since Feb 06 2019
 *
 */
@Entity
@Table(name = "vets")
public class Vet extends Person {
    
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties",
				joinColumns = @JoinColumn(name = "vet_id"),
				inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	private Set<Specialty> specialties = new HashSet<>();

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
}