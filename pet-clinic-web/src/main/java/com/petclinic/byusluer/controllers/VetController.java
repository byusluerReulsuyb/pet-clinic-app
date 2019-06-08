package com.petclinic.byusluer.controllers;


import com.petclinic.byusluer.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/vets*", "/vets*/*"})
@Controller
public class VetController {

    private  VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({""})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());


        return "vets/vet_index";
    }
}
