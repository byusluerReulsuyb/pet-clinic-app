package com.petclinic.byusluer.services.springdatajpa;

import com.petclinic.byusluer.model.Owner;
import com.petclinic.byusluer.repositories.OwnerRepository;
import com.petclinic.byusluer.repositories.PetRepository;
import com.petclinic.byusluer.repositories.PetTypeRepository;
import com.petclinic.byusluer.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJPAService implements OwnerService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    public OwnerJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName) ;
    }

    @Override
    public Set<Owner> findAll() {
      Set<Owner> owners = new HashSet<>();
      ownerRepository.findAll().forEach(owners::add);
      return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optOwner= ownerRepository.findById(aLong);
        if (optOwner.isPresent()){
            return optOwner.get();
        }else {
            return null;
        }
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
         ownerRepository.deleteById(aLong);
    }
}
