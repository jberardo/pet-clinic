package io.joca.petclinicdata.models;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class Owner extends Person {

	public Owner() {
		super("", "");
	}
	
	public Owner(String firstname, String lastname) {
		super(firstname, lastname);
	}
}