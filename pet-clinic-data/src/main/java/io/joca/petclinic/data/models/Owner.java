package io.joca.petclinic.data.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class Owner extends Person {

	private String address;
	private String city;
	private String phone;
	private Set<Pet> pets = new HashSet<>();
	
	public Owner() {
		super("", "");
	}
	
	public Owner(String firstname, String lastname) {
		super(firstname, lastname);
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
}