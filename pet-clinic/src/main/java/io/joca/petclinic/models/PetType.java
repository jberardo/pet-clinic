package io.joca.petclinic.models;

import java.util.Objects;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class PetType {
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

    public PetType name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PetType)) {
            return false;
        }
        PetType petType = (PetType) o;
        return Objects.equals(name, petType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + "}";
    }

}