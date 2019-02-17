package io.joca.petclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.joca.petclinic.models.Vet;
import io.joca.petclinic.services.VetService;

/**
 * 
 * @author Joao Berardo
 * @since Feb. 07, 2019
 *
 */
@RequestMapping("/vets")
@Controller
public class VetController {

	private VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}
	
	@RequestMapping({ "", "/", "/index", "/index.html", "/vets.html" })
	public String listVets(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}
	
	@RequestMapping("/api")
	public @ResponseBody Set<Vet> getVetsJson() {
		return vetService.findAll();
	}
}
