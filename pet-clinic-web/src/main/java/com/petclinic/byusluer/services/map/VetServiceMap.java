package com.petclinic.byusluer.services.map;

import com.petclinic.byusluer.model.Specialty;
import com.petclinic.byusluer.model.Vet;
import com.petclinic.byusluer.services.SpecialityService;
import com.petclinic.byusluer.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

     private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if (vet != null){
            if (vet.getSpecialities().size() > 0){
                vet.getSpecialities().forEach(specialty ->{
                    if (specialty.getId() == null){
                        Specialty savedSpecialty = specialityService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
        }

        return super.save(vet);
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
