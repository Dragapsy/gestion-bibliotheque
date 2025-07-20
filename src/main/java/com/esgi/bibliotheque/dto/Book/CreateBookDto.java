package com.esgi.bibliotheque.dto.Book;

import jakarta.validation.constraints.NotBlank;

public record CreateBookDto(
        @NotBlank String titre,
        @NotBlank String auteur,
        String genre
) {}
