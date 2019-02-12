package io.joca.petclinic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Joao Berardo
 * @since Feb 06 2019
 *
 */
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {

	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}