package com.petclinic.byusluer.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends  Person{

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    private Set<Specialty> specialities = new HashSet<>();

    public Set<Specialty> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Specialty> specialities) {
        this.specialities = specialities;
    }
}
