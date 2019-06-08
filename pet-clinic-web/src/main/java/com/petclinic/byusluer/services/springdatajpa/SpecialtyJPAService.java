package com.petclinic.byusluer.services.springdatajpa;

import com.petclinic.byusluer.model.Specialty;
import com.petclinic.byusluer.repositories.SpecialityRepository;
import com.petclinic.byusluer.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class SpecialtyJPAService implements SpecialityService {

    private SpecialityRepository specialityRepository;

    public SpecialtyJPAService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialityRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {

        return specialityRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {

        specialityRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {

        specialityRepository.deleteById(aLong);
    }
}
