package com.esgi.bibliotheque;

import com.esgi.bibliotheque.entity.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookConstructorAndGetters() {
        Book book = new Book();
        book.setTitre("Clean Code");
        book.setAuteur("Robert C. Martin");
        book.setGenre("Informatique");

        assertEquals("Clean Code", book.getTitre());
        assertEquals("Robert C. Martin", book.getAuteur());
        assertEquals("Informatique", book.getGenre());
    }
}
