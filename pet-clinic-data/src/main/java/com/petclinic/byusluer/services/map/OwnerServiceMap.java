package com.petclinic.byusluer.services.map;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.services.CrudService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner,Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(),owner);   // this is a good usage, revisit it!
    }

    @Override
    public void delete(Owner owner) {

        super.delete(owner);

    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }
}
