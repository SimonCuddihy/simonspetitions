package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a petition in the system.
 * Contains petition details and a list of signatures.
 */

public class Petition {
    private Long id; // Unique identifier for the petition
    private String title; // title of petition
    private String description; // descroption of the petition
    private String creator; // Name of person who created the petition

    // List of signatures on the petition
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
