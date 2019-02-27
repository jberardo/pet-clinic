package io.joca.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.joca.petclinic.models.Owner;
import io.joca.petclinic.models.Pet;
import io.joca.petclinic.models.PetType;
import io.joca.petclinic.models.Specialty;
import io.joca.petclinic.models.Vet;
import io.joca.petclinic.models.Visit;
import io.joca.petclinic.services.OwnerService;
import io.joca.petclinic.services.PetTypeService;
import io.joca.petclinic.services.SpecialtyService;
import io.joca.petclinic.services.VetService;
import io.joca.petclinic.services.VisitService;

/**
 * 
 * @author Joao Berardo
 * @since Feb. 07, 2019
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		if (petTypeService.findAll().size() == 0) {
			loadData();
		}
	}

	private void loadData() {
        PetType savedDogPetType = petTypeService.save(
        		PetType.builder().name("Dog").build());

        PetType savedCatPetType = petTypeService.save(
        		PetType.builder().name("Cat").build());

        Specialty savedRadiology = specialtyService.save(
        		Specialty.builder().description("Radiology").build());

        Specialty savedSurgery = specialtyService.save(
        		Specialty.builder().description("Surgery").build());

//        Specialty savedDentistry = specialtyService.save(
//        		Specialty.builder().description("Dentistry").build());

        Owner owner1 = new Owner();
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setPhone("1231231234");
        
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthdate(LocalDate.now());
        mikesPet.setName("Rosco");
        
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Fiona");
        owner2.setLastname("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setPhone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthdate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Jessie");
        vet2.setLastname("Porter");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
	}
}