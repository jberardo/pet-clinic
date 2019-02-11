package io.joca.petclinic.web.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.joca.petclinic.data.models.Owner;
import io.joca.petclinic.data.models.Pet;
import io.joca.petclinic.data.models.PetType;
import io.joca.petclinic.data.models.Specialty;
import io.joca.petclinic.data.models.Vet;
import io.joca.petclinic.data.models.Visit;
import io.joca.petclinic.data.services.OwnerService;
import io.joca.petclinic.data.services.PetTypeService;
import io.joca.petclinic.data.services.SpecialtyService;
import io.joca.petclinic.data.services.VetService;
import io.joca.petclinic.data.services.VisitService;

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
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType dogSaved = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType catSaved = petTypeService.save(cat);
		
		System.out.println("Loaded PetTypes....");
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiology);
		
		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedSurgery = specialtyService.save(surgery);
		
		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry);
		
		System.out.println("Loaded Specialties....");
		
        Owner owner1 = new Owner();
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");
        owner1.setAddress("123 Elm Street");
        owner1.setCity("Muppet City");
        owner1.setPhone("15552212");
        ownerService.save(owner1);
        
        Pet pet1 = new Pet();
        pet1.setPetType(dogSaved);
        pet1.setName("Rosco");
        pet1.setBirthdate(LocalDate.now());
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Fiona");
        owner2.setLastname("Glenanne");
        owner2.setAddress("321 Elmo Street");
        owner2.setCity("Uranus City");
        owner2.setPhone("15552212");
        
        Pet pet2 = new Pet();
        pet2.setPetType(catSaved);
        pet2.setName("Morty");
        pet2.setBirthdate(LocalDate.now());
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        
        ownerService.save(owner2);

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
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
        
        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);
        
        System.out.println("Loaded Visits....");
	}
}