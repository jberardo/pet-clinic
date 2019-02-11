package io.joca.petclinic.data.models;

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
@Table(name = "types")
public class PetType extends BaseEntity {
	
	@Column(name = "name")
    private String name;

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}