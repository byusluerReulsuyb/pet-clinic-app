package com.petclinic.byusluer.repositories;

import com.petclinic.byusluer.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
