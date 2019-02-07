package io.joca.petclinicdata.services;

import java.util.Set;

/**
 * Created by Joao Berardo on Feb 07 2019
 * @param <T> Type
 * @param <ID> Id Type
 */
public interface CrudService<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}