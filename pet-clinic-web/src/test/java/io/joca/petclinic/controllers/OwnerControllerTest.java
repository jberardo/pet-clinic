package io.joca.petclinic.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.joca.petclinic.models.Owner;
import io.joca.petclinic.services.OwnerService;

/**
 * 
 * @author Joao Berardo
 * @since Feb. 12, 2019
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	private OwnerService service;
	
	@InjectMocks
	private OwnerController controller;
	
	private MockMvc mock;
	
	@BeforeEach
	protected void setUp() {
		Set<Owner> owners;
		owners = new HashSet<Owner>();
		
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());
		
		mock = MockMvcBuilders
				.standaloneSetup(controller)
				.build();
	}


    @Test
    protected void findOwners() throws Exception {
    	mock.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(service);
    }

    @Test
    protected void processFindFormReturnMany() throws Exception {
        when(service.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
                        Owner.builder().id(2l).build()));

        mock.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    protected void processFindFormReturnOne() throws Exception {
        when(service.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1l).build()));

        mock.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }
    
    @Test
    protected void processFindFormEmptyReturnMany() throws Exception {
    	when(service.findAllByLastNameLike(anyString())).thenReturn(
    			Arrays.asList(Owner.builder().id(1L).build(),
    					Owner.builder().id(2L).build()));
    	
    	mock.perform(get("/owners")
    			.param("lastname", ""))
    		.andExpect(status().isOk())
    		.andExpect(view().name("owners/ownersList"))
    		.andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    protected void displayOwner() throws Exception {
        when(service.findById(anyLong())).thenReturn(Owner.builder().id(1l).build());

        mock.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
    }
    
    @Test
    protected void initCreationForm() throws Exception {
        mock.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(service);
    }

    @Test
    protected void processCreationForm() throws Exception {
        when(service.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1l).build());

        mock.perform(post("/owners/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        verify(service).save(ArgumentMatchers.any());
    }

    @Test
    protected void initUpdateOwnerForm() throws Exception {
        when(service.findById(anyLong())).thenReturn(Owner.builder().id(1l).build());

        mock.perform(get("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(service);
    }

    @Test
    protected void processUpdateOwnerForm() throws Exception {
        when(service.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1l).build());


        mock.perform(post("/owners/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        verify(service).save(ArgumentMatchers.any());
    }
}