package com.petclinic.byusluer.services.map;

import com.petclinic.byusluer.model.Pet;
import com.petclinic.byusluer.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
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
