package io.joca.petclinic.data.models;

import java.util.Objects;

/**
 * Created by Joao Beraardo on Feb 06 2019
 */
public class Person extends BaseEntity {
    private String firstname;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;
        
        return Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "{" + " firstname='" + getFirstname() + "'" + ", lastname='" + getLastname() + "'" + "}";
    }

}