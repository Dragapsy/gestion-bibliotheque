package com.esgi.bibliotheque.patterns.builder;

import com.esgi.bibliotheque.entity.Book;

import java.util.UUID;
public class BookBuilder {
    private UUID id = UUID.randomUUID();
    private String titre = "Titre Exemple";
    private String auteur = "Auteur Exemple";
    private String genre = "Genre";

    public BookBuilder withTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public BookBuilder withAuteur(String auteur) {
        this.auteur = auteur;
        return this;
    }

    public BookBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public Book build() {
        Book book = new Book();
        book.setId(id);
        book.setTitre(titre);
        book.setAuteur(auteur);
        book.setGenre(genre);
        return book;
    }
}