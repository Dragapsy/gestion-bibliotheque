package com.esgi.bibliotheque.patterns.builder;

import com.esgi.bibliotheque.entity.Emprunt;
import com.esgi.bibliotheque.entity.Book;
import com.esgi.bibliotheque.entity.User;

import java.time.LocalDate;
import java.util.UUID;
public class EmpruntBuilder {
    private UUID id = UUID.randomUUID();
    private User user;
    private Book book;
    private LocalDate dateEmprunt = LocalDate.now();
    private LocalDate dateRetour = null;
    private boolean rendu = false;

    public EmpruntBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public EmpruntBuilder withBook(Book book) {
        this.book = book;
        return this;
    }

    public EmpruntBuilder withDateEmprunt(LocalDate date) {
        this.dateEmprunt = date;
        return this;
    }

    public EmpruntBuilder returnedOn(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
        this.rendu = true;
        return this;
    }

    public Emprunt build() {
        Emprunt emprunt = new Emprunt();
        emprunt.setId(id);
        emprunt.setUser(user);
        emprunt.setBook(book);
        emprunt.setDateEmprunt(dateEmprunt);
        emprunt.setDateRetour(dateRetour);
        emprunt.setRendu(rendu);
        return emprunt;
    }
}
