package com.esgi.bibliotheque.patterns.factory;

import com.esgi.bibliotheque.entity.Emprunt;
import com.esgi.bibliotheque.entity.User;
import com.esgi.bibliotheque.entity.Book;
import com.esgi.bibliotheque.patterns.builder.EmpruntBuilder;
import com.esgi.bibliotheque.patterns.singleton.StatsManager;

import java.time.LocalDate;

public class EmpruntFactory {
    public static Emprunt createDefaultEmprunt(User user, Book book) {

        StatsManager.getInstance().incrementEmprunts();

        return new EmpruntBuilder()
                .withUser(user)
                .withBook(book)
                .withDateEmprunt(LocalDate.now())
                .build();
    }
}
