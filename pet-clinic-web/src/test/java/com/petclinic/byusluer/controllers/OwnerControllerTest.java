package com.petclinic.byusluer.controllers;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {


    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;
    Set<Owner> owners;
    MockMvc mockMvc;
    Long id = 1L;
    Long secondId = 2L;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner owner1 = Owner.builder().id(id).build();
        Owner owner2 = Owner.builder().id(secondId).build();
        owners.add(owner1);
        owners.add(owner2);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }
    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/owner_index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }
    @Test
    void findOwners() throws Exception {

        mockMvc.perform(get("/owners/find")).andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(ownerService);
    }
}