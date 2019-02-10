package io.joca.petclinic.data.models;

import java.time.LocalDate;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class Pet extends BaseEntity {
	
    private PetType petType;
    private Owner owner;
    private LocalDate birthdate;


    public Pet() {
    }

    public Pet(PetType petType, Owner owner, LocalDate birthdate) {
        this.petType = petType;
        this.owner = owner;
        this.birthdate = birthdate;
    }

    public PetType getPetType() {
        return this.petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Pet petType(PetType petType) {
        this.petType = petType;
        return this;
    }

    public Pet owner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public Pet birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }
}