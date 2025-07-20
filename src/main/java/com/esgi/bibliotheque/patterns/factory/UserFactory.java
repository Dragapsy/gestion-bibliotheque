package com.esgi.bibliotheque.patterns.factory;

import com.esgi.bibliotheque.entity.User;
import com.esgi.bibliotheque.patterns.builder.UserBuilder;

public class UserFactory {
    public static User createDefaultUser() {
        return new UserBuilder()
                .withEmail("default@esgi.fr")
                .withNom("Default")
                .withPrenom("User")
                .build();
    }
}
