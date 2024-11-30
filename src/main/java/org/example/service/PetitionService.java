package org.example.service;

import org.example.model.Petition;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetitionService {
    private List<Petition> petitions = new ArrayList<>();
    private Long nextId = 1L;

    public Petition createPetition(String title, String description, String creator) {
        Petition petition = new Petition(nextId++, title, description, creator);
        petitions.add(petition);
        return petition;
    }

    public List<Petition> getAllPetitions() {
        return new ArrayList<>(petitions);
    }

    public Optional<Petition> getPetitionById(Long id) {
        return petitions.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Petition> searchPetitions(String query) {
        return petitions.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        p.getDescription().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }
}
