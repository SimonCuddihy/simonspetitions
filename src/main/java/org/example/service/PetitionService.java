package org.example.service;

import org.example.model.Petition;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
}
