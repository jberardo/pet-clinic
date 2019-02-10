package io.joca.petclinic.data.models;

import java.util.Set;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class Owner extends Person {

	private Set<Pet> pets;
	
	public Owner() {
		super("", "");
	}
	
	public Owner(String firstname, String lastname) {
		super(firstname, lastname);
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
}