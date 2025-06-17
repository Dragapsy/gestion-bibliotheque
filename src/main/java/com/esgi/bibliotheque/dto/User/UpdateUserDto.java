package com.esgi.bibliotheque.dto.User;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto(
        @NotBlank String prenom,
        @NotBlank String nom,
        @NotBlank String typeAbonnement
) {}
