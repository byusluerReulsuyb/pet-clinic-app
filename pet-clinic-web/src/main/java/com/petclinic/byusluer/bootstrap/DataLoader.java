package com.petclinic.byusluer.bootstrap;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.model.Vet;
import com.petclinic.byusluer.services.OwnerService;
import com.petclinic.byusluer.services.VetService;
import com.petclinic.byusluer.services.map.OwnerServiceMap;
import com.petclinic.byusluer.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component // -> spring bean
public class DataLoader implements CommandLineRunner {

    public final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Ali");
        owner1.setLastName("AtaBak");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Veli");
        owner2.setLastName("VeliBaba");
        owner2.setId(2L);

        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet("Zorby", "Pifor");
        vet1.setId(1L);

        vetService.save(vet1);

        Vet vet2 = new Vet("Lord", "Verty");
        vet2.setId(2L);
        vetService.save(vet2);

        System.out.println("Loaded vets");



    }
}
