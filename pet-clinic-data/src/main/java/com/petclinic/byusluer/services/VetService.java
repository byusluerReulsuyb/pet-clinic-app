package com.petclinic.byusluer.services;

import com.petclinic.byusluer.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet Vet);

    Set<Vet> findAll();
}
