package io.joca.petclinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.Specialty;
import io.joca.petclinic.data.models.Vet;
import io.joca.petclinic.data.services.SpecialtyService;
import io.joca.petclinic.data.services.VetService;

/**
 * 
 * @author Joao Berardo
 * @since Feb 07 2019
 *
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	
	private SpecialtyService specialtyService;
	
    public VetServiceMap(SpecialtyService specialtyService) {
    	super();
    	this.specialtyService = specialtyService;
    }
    
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
    	
    	if (vet.getSpecialties().size() > 0) {
    		vet.getSpecialties().forEach(s -> {
    			if (s.getId() == null) {
    				Specialty savedSpecialty = specialtyService.save(s);
    				savedSpecialty.setId(s.getId());
    			}
    		});
    	}
    	
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}