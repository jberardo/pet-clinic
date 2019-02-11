package io.joca.petclinic.data.models;

import java.io.Serializable;

/**
 * 
 * @author Joao Berardo
 * @since Feb 06 2019
 *
 */
public class BaseEntity implements Serializable {
	
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}