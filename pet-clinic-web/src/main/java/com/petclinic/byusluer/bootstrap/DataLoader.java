package com.petclinic.byusluer.bootstrap;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.model.Pet;
import com.petclinic.byusluer.model.PetType;
import com.petclinic.byusluer.model.Vet;
import com.petclinic.byusluer.services.OwnerService;
import com.petclinic.byusluer.services.PetTypeService;
import com.petclinic.byusluer.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component // -> spring bean
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);


        Owner owner1 = new Owner();
        owner1.setFirstName("Ali");
        owner1.setLastName("AtaBak");
        owner1.setAddress("Baker Street, Oxford");
        owner1.setCity("Oxford");
        owner1.setTelephone("2131313");

        Pet  zinar = new Pet();
        zinar.setPetType(savedDog);
        zinar.setOwner(owner1);
        zinar.setName("Zınar");
        zinar.setBirtDate(LocalDate.ofYearDay(1995,39));
        owner1.getPets().add(zinar);

        ownerService.save(owner1);

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
        susluMualla.setBirtDate(LocalDate.of(2016,11,14));
        susluMualla.setName("susluMualla");

        owner2.getPets().add(susluMualla);

        susluMualla.setOwner(owner2);


        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet("Zorby", "Pifor");


        vetService.save(vet1);

        Vet vet2 = new Vet("Lord", "Verty");
        vetService.save(vet2);

        System.out.println("Loaded vets");


        System.out.println(" \n \n \n \n  finished!");



    }
}
