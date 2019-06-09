

package com.petclinic.byusluer.bootstrap;
import com.petclinic.byusluer.model.*;
import com.petclinic.byusluer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component // -> spring bean
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {

            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();

        PetType fish = new PetType();

        fish.builder().name("Fish");
        PetType savedFish = petTypeService.save(fish);

        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        Specialty radiology = new Specialty();
        Specialty cardiology = new Specialty();
        cardiology.builder().description("cardiology");
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");

        Specialty savedRadiology = specialityService.save(radiology);
        Specialty savedSurgery = specialityService.save(surgery);
        Specialty savedDentistry = specialityService.save(dentistry);
        Specialty savedcardiology = specialityService.save(cardiology);


        Owner owner1 = new Owner();
        owner1.setFirstName("Ali");
        owner1.setLastName("AtaBak");
        owner1.setAddress("Baker Street, Oxford");
        owner1.setCity("Oxford");
        owner1.setTelephone("2131313");

        Owner owner3 = new Owner();
        owner3.builder().firstName("Ali").lastName("tahinpekmez").address("Antalya").city("Ant").telephone("4343");

        Pet zinar = new Pet();
        zinar.setPetType(savedDog);
        zinar.setOwner(owner1);
        zinar.setName("Zınar");
        zinar.setBirthDate(LocalDate.ofYearDay(1995, 39));
        owner1.getPets().add(zinar);

        ownerService.save(owner1);

        Visit ziNarVisit = new Visit();
        ziNarVisit.setDate(LocalDate.now());
        ziNarVisit.setDescription("routine check");
        ziNarVisit.setPet(zinar);

        zinar.getVisits().add(ziNarVisit);

        visitService.save(ziNarVisit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Veli");
        owner2.setLastName("VeliBaba");
        owner2.setAddress("HillTown, PurtifyRoad");
        owner2.setCity("Edinburg");
        owner2.setAddress("45364357654");

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat = petTypeService.save(cat);

        Pet susluMualla = new Pet();
        susluMualla.setPetType(savedCat);
        susluMualla.setBirthDate(LocalDate.of(2016, 11, 14));
        susluMualla.setName("susluMualla");

        owner2.getPets().add(susluMualla);



        susluMualla.setOwner(owner2);


        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("zinar");
        vet1.setLastName("nafizbaligi");


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("suslu");
        vet2.setLastName("nafiz");
        vetService.save(vet2);

        vet1.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedDentistry);
        vet1.getSpecialities().add(dentistry);

        System.out.println("Loaded vets");


        System.out.println(" \n \n \n \n  finished!");
    }
}
