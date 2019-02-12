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

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

	private static final String LAST_NAME = "Smith";

	@InjectMocks
	OwnerServiceJpa service;
	
	@Mock
	OwnerRepository repository;
	
	Owner owner;
	
	@BeforeEach
	void setUp() throws Exception {
		owner = Owner.builder().id(1L).lastname(LAST_NAME).build();
	}

	@Test
	void testFindAll() {

		Set<Owner> ownersSet = new HashSet<>();
		ownersSet.add(Owner.builder().id(1L).build());
		ownersSet.add(Owner.builder().id(2L).build());
		
		when(repository.findAll()).thenReturn(ownersSet);
		
		Set<Owner> owners = service.findAll();
		
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	void testFindById() {
		
		when(repository.findById(anyLong())).thenReturn(Optional.of(owner));
		
		Owner o = service.findById(1L);
		
		assertNotNull(o);
	}
	
	@Test
	void testFindByIdNotFound() {
		
		when(repository.findById(anyLong())).thenReturn(Optional.empty());
		Owner o = service.findById(1L);
		
		assertNull(o);
	}

	@Test
	void testSave() {
		
		Owner ownerToSave = Owner.builder().id(1L).build();
		when(repository.save(any())).thenReturn(owner);
		Owner saved = repository.save(ownerToSave);
		
		assertNotNull(saved);
	}

	@Test
	void testDelete() {
		
		service.delete(owner);
		
		verify(repository).delete(any());
	}
	
	@Test
	void testDeleteById() {
		
		service.deleteById(1L);
		
		verify(repository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {

		when(repository.findByLastname(any())).thenReturn(owner);
		Owner smith = service.findByLastName(LAST_NAME);

		assertNotNull(smith);
		assertEquals(LAST_NAME, smith.getLastname());
		verify(repository).findByLastname(any());
	}
}