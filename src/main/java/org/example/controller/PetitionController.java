package org.example.controller;

import org.example.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/petition/new")
    public String createPetitionForm() {
        return "create-petition";
    }

    @PostMapping("/petition/new")
    public String createPetition(@RequestParam String title,
                                 @RequestParam String description,
                                 @RequestParam String creator) {
        petitionService.createPetition(title, description, creator);
        return "redirect:/petitions";
    }
}