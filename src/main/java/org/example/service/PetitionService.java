package org.example.service;

import org.example.model.Petition;
import org.example.model.Signature;
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

    public PetitionService() {
        // sample data
        createPetition("Save the Parks", "Protect our local parks from development", "John Doe");
        createPetition("Better Public Transport", "Improve bus services in our city", "Jane Smith");
    }

    public boolean signPetition(Long petitionId, String name, String email) {
        Optional<Petition> petition = getPetitionById(petitionId);
        if (petition.isPresent()) {
            petition.get().getSignatures().add(new Signature(name, email));
            return true;
        }
        return false;
    }

}