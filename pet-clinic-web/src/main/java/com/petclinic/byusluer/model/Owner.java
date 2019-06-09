package com.petclinic.byusluer.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;






@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(String firstName, String lastName, String address, Set<Pet> pets, String city, String telephone) {
        super(firstName, lastName);
        this.address = address;
        this.pets = pets;
        this.city = city;
        this.telephone = telephone;
    }

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

}
