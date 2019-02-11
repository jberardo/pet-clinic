package io.joca.petclinic.data.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author Joao Berardo
 * @since Feb 06 2019
 *
 */
@MappedSuperclass
public class Person extends BaseEntity {
	
	@Column(name = "first_name")
    private String firstname;
	
	@Column(name = "last_name")
    private String lastname;

    public Person() {
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}