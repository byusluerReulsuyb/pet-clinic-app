package com.petclinic.byusluer.services.map;

import com.petclinic.byusluer.model.Visit;
import com.petclinic.byusluer.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit != null) {

            if (visit.getPet() == null || visit.getPet().getOwner() == null) {

                throw new RuntimeException("Invalid Visit");
            }
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
         super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
