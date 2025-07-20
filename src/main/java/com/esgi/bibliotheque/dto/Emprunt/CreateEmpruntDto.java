package com.esgi.bibliotheque.dto.Emprunt;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CreateEmpruntDto(
        @NotNull UUID userId,
        @NotNull UUID bookId,
        @NotNull LocalDate dateEmprunt
) {}
