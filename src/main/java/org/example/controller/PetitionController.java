package org.example.controller;

import org.example.model.Petition;
import org.example.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/petition/{id}")
    public String viewPetition(@PathVariable Long id, Model model) {
        var petition = petitionService.getPetitionById(id);
        if (petition.isPresent()) {
            model.addAttribute("petition", petition.get());
            return "view-petition";
        }
        return "redirect:/petitions";
    }

    @PostMapping("/petition/{id}/sign")
    public String signPetition(@PathVariable Long id,
                               @RequestParam String name,
                               @RequestParam String email) {
        petitionService.signPetition(id, name, email);
        return "redirect:/petition/" + id;
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String search(@RequestParam String query, Model model) {
        model.addAttribute("petitions", petitionService.searchPetitions(query));
        model.addAttribute("query", query);
        return "search-results";
    }
}