package com.petclinic.byusluer.services.map;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.model.Pet;
import com.petclinic.byusluer.services.PetService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return findByID(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet) {

        super.delete(pet);

    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }
}
