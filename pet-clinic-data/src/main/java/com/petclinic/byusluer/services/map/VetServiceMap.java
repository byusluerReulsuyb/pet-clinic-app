package com.petclinic.byusluer.services.map;

import com.petclinic.byusluer.model.Vet;
import com.petclinic.byusluer.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void delete(Vet vet) {

        super.delete(vet);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
