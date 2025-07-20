package com.esgi.bibliotheque.dto.Book;

import java.util.UUID;

public record BookResponseDto(
        UUID id,
        String titre,
        String auteur,
        String genre,
        boolean disponible
) {}
