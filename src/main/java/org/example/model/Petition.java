package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private Long id;
    private String title;

    private String description;
    private String creator;

    private List<Signature> signatures = new ArrayList<>();

    // Constructor
    public Petition(Long id, String title, String description, String creator) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator = creator;
    }

    // Getters/setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Signature methods
    public void addSignature(Signature signature) {
        signatures.add(signature);
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
