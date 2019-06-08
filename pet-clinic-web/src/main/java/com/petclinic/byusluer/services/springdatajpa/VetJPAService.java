package com.petclinic.byusluer.services.springdatajpa;

import com.petclinic.byusluer.model.Vet;
import com.petclinic.byusluer.repositories.VetRepository;
import com.petclinic.byusluer.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class VetJPAService implements VetService {


    private VetRepository vetRepository;

    public VetJPAService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
      Set<Vet> vets = new HashSet<>();

        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {

           Optional<Vet> optionalVet = vetRepository.findById(id);
           if (optionalVet.isPresent()){
               return  optionalVet.get();
           }else
               return null;

    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {

        vetRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {

             vetRepository.deleteById(id);
    }
}
