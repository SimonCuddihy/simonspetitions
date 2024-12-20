package org.example.controller;

import org.example.model.Petition;
import org.example.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Controller handling web requests for the petition application.
 * Maps URLs to appropriate handler methods and manages view resolution.
 */

@Controller
public class PetitionController {
    private static final Logger logger = LoggerFactory.getLogger(PetitionController.class);

    @Autowired
    private PetitionService petitionService;

    //Displays the home page
    @GetMapping("/")
    public String home() {
        return "home";
    }

    //Displays all petitions in the system
    @GetMapping("/petitions")
    public String listPetitions(Model model) {
        try {
            logger.info("Fetching all petitions");
            List<Petition> petitions = petitionService.getAllPetitions();
            logger.info("Found {} petitions", petitions.size());
            model.addAttribute("petitions", petitions);
            return "petitions";
        } catch (Exception e) {
            logger.error("Error fetching petitions", e);
            throw e;
        }
    }

    @GetMapping("/petition/new")
    public String createPetitionForm() {
        return "create-petition";
    }

    // Handles creating a new petition
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

    // Handles the signing of a petition
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

    // Searching for a petition
    @PostMapping("/search")
    public String search(@RequestParam String query, Model model) {
        model.addAttribute("petitions", petitionService.searchPetitions(query));
        model.addAttribute("query", query);
        return "search-results";
    }
}