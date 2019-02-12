package io.joca.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.joca.petclinic.models.Owner;

/**
 * 
 * @author Joao Berardo
 * @since Feb. 12, 2019
 *
 */
class OwnerServiceMapTest {

	private final Long OWNER_ID = 1L;
	private final String OWNER_NAME = "John";
	private final String OWNER_LNAME = "Doe";
	
	
	OwnerServiceMap service;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		
		Owner o = new Owner();
		o.setId(OWNER_ID);
		o.setFirstname(OWNER_NAME);
		o.setLastname(OWNER_LNAME);
		
		service.save(o);
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = service.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = service.findById(OWNER_ID);
		
		assertEquals(OWNER_ID, owner.getId());
		assertEquals(OWNER_NAME, owner.getFirstname());
	}

	@Test
	void testSaveOwnerExistingId() {
		Owner o = new Owner();
		o.setId(OWNER_ID);
		o.setFirstname(OWNER_NAME);
		o.setLastname(OWNER_LNAME);
		
		Owner saved = service.save(o);
		
		assertEquals(saved, o);
		assertEquals(saved.getId(), OWNER_ID);
	}
	
	@Test
	void testSaveOwnerNoId() {
		Owner owner = service.save(Owner.builder().build());
		
		assertNotNull(owner);
		assertNotNull(owner.getId());
	}

	@Test
	void testDeleteOwner() {
		service.delete(service.findById(OWNER_ID));
		
		assertEquals(0, service.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		service.deleteById(OWNER_ID);
		
		assertEquals(0, service.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner owner = service.findByLastName(OWNER_LNAME);

		assertNotNull(owner);
		assertEquals(owner.getLastname(), OWNER_LNAME);
	}
	
	@Test
	void testFindByLastNameNotFound() {
		Owner owner = service.findByLastName("foo");

		assertNull(owner);
	}
}