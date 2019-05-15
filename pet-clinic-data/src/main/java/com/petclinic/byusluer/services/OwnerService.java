package com.petclinic.byusluer.services;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.model.Pet;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {


    Owner findByLastName(String lastName);





}
