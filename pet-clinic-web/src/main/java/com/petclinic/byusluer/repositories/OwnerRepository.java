package com.petclinic.byusluer.repositories;

import com.petclinic.byusluer.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);
}
