package com.esgi.bibliotheque.dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
        @NotBlank String prenom,
        @NotBlank String nom,
        @Email @NotBlank String email,
        @NotBlank String typeAbonnement
) {}
