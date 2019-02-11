package io.joca.petclinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import io.joca.petclinic.data.models.Visit;
import io.joca.petclinic.data.services.VisitService;

/**
 * 
 * @author Joao Berardo
 * @since Feb 11 2019
 *
 */
@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit) {
		
		if (visit.getPet() == null
				|| visit.getPet().getId() == null
				|| visit.getPet().getOwner() == null
				|| visit.getPet().getOwner().getId() == null) {
		
			throw new RuntimeException("Invalid Visit");
		}
		
		return super.save(visit);
	}

	@Override
	public void delete(Visit visit) {
		super.delete(visit);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}