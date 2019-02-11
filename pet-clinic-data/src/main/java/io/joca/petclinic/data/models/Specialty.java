package io.joca.petclinic.data.models;

/**
 * 
 * @author Joao Berardo
 * @since Feb 06 2019
 *
 */
public class Specialty extends BaseEntity {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}