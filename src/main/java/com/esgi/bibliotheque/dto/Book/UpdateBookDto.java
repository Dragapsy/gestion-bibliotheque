package com.esgi.bibliotheque.dto.Book;

import jakarta.validation.constraints.NotBlank;

public record UpdateBookDto(
        @NotBlank String titre,
        @NotBlank String auteur,
        String genre,
        boolean disponible
) {}
