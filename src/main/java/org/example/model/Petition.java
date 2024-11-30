package org.example.model;

public class Petition {
    private Long id;
    private String title;

    private String description;
    private String creator;

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
}
