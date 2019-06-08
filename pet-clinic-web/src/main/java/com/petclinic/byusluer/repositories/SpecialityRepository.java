package com.petclinic.byusluer.repositories;

import com.petclinic.byusluer.model.Specialty;
import com.petclinic.byusluer.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Specialty,Long> {
}
