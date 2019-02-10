package io.joca.petclinic.data.models;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class PetType extends BaseEntity {
	
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