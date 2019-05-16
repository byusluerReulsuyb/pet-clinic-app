package com.petclinic.byusluer.services.map;
import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.services.OwnerService;
import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
        return super.save(owner.getId(), owner);   // this is a good usage, revisit it!
    }

    @Override
    public void delete(Owner owner) {

        super.delete(owner);

    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}