package com.esgi.bibliotheque;

import com.esgi.bibliotheque.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserConstructorAndGetters() {
        User user = new User();
        user.setNom("Doe");
        user.setPrenom("John");
        user.setEmail("john.doe@example.com");

        assertEquals("Doe", user.getNom());
        assertEquals("John", user.getPrenom());
        assertEquals("john.doe@example.com", user.getEmail());
    }
}
