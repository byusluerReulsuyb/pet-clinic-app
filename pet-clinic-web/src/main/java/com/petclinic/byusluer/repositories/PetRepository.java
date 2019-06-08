package com.petclinic.byusluer.repositories;

import com.petclinic.byusluer.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
