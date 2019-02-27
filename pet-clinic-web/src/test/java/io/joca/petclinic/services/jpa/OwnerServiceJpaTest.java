package io.joca.petclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.joca.petclinic.models.Owner;
import io.joca.petclinic.repositories.OwnerRepository;

/**
 * 
 * @author Joao Berardo
 * @since Feb. 12, 2019
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

	private static final String LAST_NAME = "Smith";

	@InjectMocks
	private OwnerServiceJpa service;
	
	@Mock
	private OwnerRepository repository;
	
	private Owner returnOwner;
	
	@BeforeEach
	protected void setUp() throws Exception {
		Owner o = new Owner();
		o.setId(1L);
		o.setLastname(LAST_NAME);
		returnOwner = o;
	}

	@Test
	protected void testFindAll() {

		Set<Owner> ownersSet = new HashSet<>();
		ownersSet.add(Owner.builder().id(1L).build());
		ownersSet.add(Owner.builder().id(2L).build());
		
		when(repository.findAll()).thenReturn(ownersSet);
		
		Set<Owner> owners = service.findAll();
		
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	protected void testFindById() {
		
		when(repository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner o = service.findById(1L);
		
		assertNotNull(o);
	}
	
	@Test
	protected void testFindByIdNotFound() {
		
		when(repository.findById(anyLong())).thenReturn(Optional.empty());
		Owner o = service.findById(1L);
		
		assertNull(o);
	}

	@Test
	protected void testSave() {
		
		Owner ownerToSave = Owner.builder().id(1L).build();
		when(repository.save(any())).thenReturn(returnOwner);
		Owner saved = repository.save(ownerToSave);
		
		assertNotNull(saved);
	}

	@Test
	protected void testDelete() {
		
		service.delete(returnOwner);
		
		verify(repository).delete(any());
	}
	
	@Test
	protected void testDeleteById() {
		
		service.deleteById(1L);
		
		verify(repository, times(1)).deleteById(anyLong());
	}

	@Test
	protected void testFindByLastName() {

		when(repository.findByLastname(any())).thenReturn(returnOwner);
		Owner smith = service.findByLastName(LAST_NAME);

		assertNotNull(smith);
		assertEquals(LAST_NAME, smith.getLastname());
		verify(repository, times(1)).findByLastname(any());
	}
}