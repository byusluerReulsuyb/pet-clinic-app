package com.petclinic.byusluer.services;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.model.Pet;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
