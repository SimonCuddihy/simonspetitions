package org.example.controller;

import org.example.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetitionController {

    @Autowired
    private PetitionService petitionService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/petitions")
    public String listPetitions(Model model) {
        model.addAttribute("petitions", petitionService.getAllPetitions());
        return "petitions";
    }
}