package com.petclinic.byusluer.services.map;

import com.petclinic.byusluer.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;
    private Long ownerId;

    @BeforeEach
    void setUp() {

        Owner owner = new Owner();

        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerId = 1L;
        Owner owner2 = Owner.builder().id(ownerId).build();
        ownerServiceMap.save(owner2);
        System.out.println(owner2.getId());

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        for (Owner owner:ownerSet) {
            System.out.println(owner.getId());

        }

        assertEquals(0,ownerSet.size());



    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingID() {
        
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        ownerServiceMap.save(owner2);

        assertEquals(id, owner2.getId());
    }

    @Test
    void saveNoID() {

        Owner owner = Owner.builder().firstName("aliveli").build();
        ownerServiceMap.save(owner);
        assertNotNull(owner.getId());
        System.out.println(owner.getId());

    }

    @Test
    void delete() {

        Owner owner3 = ownerServiceMap.findById(1L);
       assertNull(owner3);
    }

    @Test
    void deleteById() {

       ownerServiceMap.deleteById(1L);
       assertNull(ownerServiceMap.findById(1L));


    }

    @Test
    void findByLastName() {
        Owner owner3 = Owner.builder().lastName("usluer").city("antalya").build();
        ownerServiceMap.save(owner3);
        System.out.println(owner3);

        System.out.println(ownerServiceMap.findByLastName("usluer"));
        String city = "antalya";
        assertEquals(city,ownerServiceMap.findByLastName("usluer").getCity());

    }
}