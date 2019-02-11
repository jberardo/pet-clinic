package io.joca.petclinic.data.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.joca.petclinic.data.models.BaseEntity;

/**
 * 
 * @author Joao Berardo
 * @since Feb 07 2019
 *
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
	
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

    	if (object != null) {
    		if (object.getId() == null) {
    			object.setId(getNextId());
    		}
    		
    		map.put(object.getId(), object);
    	} else {
    		throw new RuntimeException("Object cannot be null");
    	}

        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }
    
    private Long getNextId() {
    	Long nextId = null;
    	
    	try {
    		nextId = Collections.max(map.keySet()) + 1;
    	} catch (Exception ex) {
    		nextId = 1L;
    	}
    	
    	return nextId;
    }
}