package com.petclinic.byusluer.services.springdatajpa;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.repositories.OwnerRepository;
import com.petclinic.byusluer.repositories.PetRepository;
import com.petclinic.byusluer.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {


    public static final Long id = 67L;
    public static final Long idWrong = 133L;

    public static final String LAST_NAME = "Smith";
    Owner returnOwner;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJPAService ownerJPAService;


    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(id).build();
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().id(3L).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner smith = ownerJPAService.findByLastName(LAST_NAME);
        assertEquals("Smith",smith.getLastName());
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());
        ownerSet.add(Owner.builder().id(3L).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> expectedOwners = ownerJPAService.findAll();

        assertEquals(3, expectedOwners.size());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerJPAService.findById(id);
        assertEquals(id, owner.getId());
        //assertEquals(idWrong,owner.getId());
        assertNotNull(owner);
    }

    @Test
    void save() {

        Owner newOwner = Owner.builder().id(1243L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner ownerToSave = ownerJPAService.save(newOwner);
        assertNotNull(ownerToSave);
    }

    @Test
    void delete() {
        ownerJPAService.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {

        ownerJPAService.deleteById(456L);
        verify(ownerRepository).deleteById(anyLong());
    }
}