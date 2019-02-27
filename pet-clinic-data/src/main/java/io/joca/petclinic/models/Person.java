package io.joca.petclinic.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Joao Berardo
 * @since Feb 06 2019
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

	@Column(name = "first_name")
    private String firstname;
	
	@Column(name = "last_name")
    private String lastname;

	public Person(Long id, String firstname, String lastname) {
		super(id);
		this.firstname = firstname;
		this.lastname = lastname;
	}
}