package com.petclinic.byusluer.services;

import com.petclinic.byusluer.model.Vet;

import java.util.Set;

public interface VetService extends  CrudService<Vet,Long> {

    @Override
    Set<Vet> findAll();

    @Override
    Vet findById(Long aLong);

    @Override
    Vet save(Vet object);

    @Override
    void delete(Vet object);

    @Override
    void deleteById(Long aLong);
}
