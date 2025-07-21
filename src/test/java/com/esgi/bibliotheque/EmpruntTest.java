package com.esgi.bibliotheque;

import com.esgi.bibliotheque.entity.Book;
import com.esgi.bibliotheque.entity.Emprunt;
import com.esgi.bibliotheque.entity.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EmpruntTest {

    @Test
    void testEmpruntConstructorAndGetters() {
        User user = new User();
        Book book = new Book();
        Emprunt emprunt = new Emprunt();
        LocalDate now = LocalDate.now();

        emprunt.setDateEmprunt(now);
        emprunt.setUser(user);
        emprunt.setBook(book);

        assertEquals(now, emprunt.getDateEmprunt());
        assertEquals(user, emprunt.getUser());
        assertEquals(book, emprunt.getBook());
    }
}
