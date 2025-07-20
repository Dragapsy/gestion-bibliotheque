package com.esgi.bibliotheque.patterns.builder;


import com.esgi.bibliotheque.entity.User;

import java.util.UUID;

public class UserBuilder {
    private UUID id = UUID.randomUUID();
    private String email = "user@esgi.fr";
    private String nom = "Nom";
    private String prenom = "Prenom";

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public UserBuilder withPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setNom(nom);
        user.setPrenom(prenom);
        return user;
    }
}