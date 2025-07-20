package com.esgi.bibliotheque.dto.Emprunt;

import java.time.LocalDate;

public record UpdateEmpruntDto(
        LocalDate dateRetour,
        boolean rendu
) {}
