package io.joca.petclinic.services;

import java.util.Set;

/**
 * 
 * @author Joao Berardo
 * @since Feb 07 2019
 *
 */
public interface CrudService<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}