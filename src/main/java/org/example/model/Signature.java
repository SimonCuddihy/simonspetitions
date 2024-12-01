package org.example.model;

/**
 * Represents a signature on a petition.
 * Contains the name and email of the person signing.
 */

public class Signature {
    private String name; // Name of the person signing the petition
    private String email; //Email of the person signing the petition

    public Signature(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
