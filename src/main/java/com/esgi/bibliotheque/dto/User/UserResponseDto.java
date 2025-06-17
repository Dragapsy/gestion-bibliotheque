package com.esgi.bibliotheque.dto.User;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String prenom,
        String nom,
        String email,
        String typeAbonnement
) {}
