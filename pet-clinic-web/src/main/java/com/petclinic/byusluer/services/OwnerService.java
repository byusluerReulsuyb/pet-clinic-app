package com.petclinic.byusluer.services;

import com.petclinic.byusluer.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {


    Owner findByLastName(String lastName);





}
