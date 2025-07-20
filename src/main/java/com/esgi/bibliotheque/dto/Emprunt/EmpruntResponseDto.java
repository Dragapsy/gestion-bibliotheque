package com.esgi.bibliotheque.dto.Emprunt;

import java.time.LocalDate;
import java.util.UUID;

public record EmpruntResponseDto(
        UUID id,
        UUID userId,
        UUID bookId,
        LocalDate dateEmprunt,
        LocalDate dateRetour,
        boolean rendu
) {}
