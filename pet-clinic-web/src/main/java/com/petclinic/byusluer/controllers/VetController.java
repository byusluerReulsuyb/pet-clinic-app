package com.petclinic.byusluer.controllers;


import com.petclinic.byusluer.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final OwnerService ownerService;


    public VetController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String listVets(Model model){







        return "vets/vet_index";
    }
}
