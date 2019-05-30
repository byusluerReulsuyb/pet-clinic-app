package com.petclinic.byusluer.services.map;

import com.petclinic.byusluer.model.Specialty;
import com.petclinic.byusluer.services.SpecialityService;

import java.util.Set;

public class SpecialityMapService extends AbstractMapService <Specialty,Long> implements SpecialityService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long aLong) {
        return findByID(aLong);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
      super.deleteById(id);
    }
}
