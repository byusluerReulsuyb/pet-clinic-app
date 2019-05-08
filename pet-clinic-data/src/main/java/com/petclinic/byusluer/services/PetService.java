package com.petclinic.byusluer.services;

import com.petclinic.byusluer.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();

}
