package com.petclinic.byusluer.bootstrap;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.model.PetType;
import com.petclinic.byusluer.model.Vet;
import com.petclinic.byusluer.services.OwnerService;
import com.petclinic.byusluer.services.PetTypeService;
import com.petclinic.byusluer.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Veli");
        owner2.setLastName("VeliBaba");

        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet("Zorby", "Pifor");


        vetService.save(vet1);

        Vet vet2 = new Vet("Lord", "Verty");
        vetService.save(vet2);

        System.out.println("Loaded vets");



    }
}
