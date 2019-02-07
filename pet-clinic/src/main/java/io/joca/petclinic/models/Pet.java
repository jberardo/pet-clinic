package io.joca.petclinic.models;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class Pet {
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) o;
        return Objects.equals(petType, pet.petType) && Objects.equals(owner, pet.owner) && Objects.equals(birthdate, pet.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petType, owner, birthdate);
    }

    @Override
    public String toString() {
        return "{" +
            " petType='" + getPetType() + "'" +
            ", owner='" + getOwner() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            "}";
    }

}