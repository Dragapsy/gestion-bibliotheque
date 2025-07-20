package com.esgi.bibliotheque.patterns.factory;

import com.esgi.bibliotheque.entity.Book;
import com.esgi.bibliotheque.patterns.builder.BookBuilder;
import com.esgi.bibliotheque.patterns.singleton.StatsManager;

public class BookFactory {
    public static Book createDefaultBook() {

        StatsManager.getInstance().incrementBooks();

        return new BookBuilder()
                .withTitre("Design Patterns")
                .withAuteur("GoF")
                .withGenre("Informatique")
                .build();

    }
}
