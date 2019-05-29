package com.petclinic.byusluer.services;
import com.petclinic.byusluer.model.PetType;

import java.util.Set;

public interface PetTypeService extends CrudService<PetType, Long> {


    @Override
    Set<PetType> findAll();

    @Override
    PetType findById(Long aLong);

    @Override
    PetType save(PetType object);

    @Override
    void delete(PetType object);

    @Override
    void deleteById(Long aLong);
}
