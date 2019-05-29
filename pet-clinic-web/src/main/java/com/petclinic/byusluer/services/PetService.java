package com.petclinic.byusluer.services;

import com.petclinic.byusluer.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet,Long> {

    @Override
    Set<Pet> findAll();

    @Override
    Pet findById(Long aLong);

    @Override
    Pet save(Pet object);

    @Override
    void delete(Pet object);

    @Override
    void deleteById(Long aLong);
}
