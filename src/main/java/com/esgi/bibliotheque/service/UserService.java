package com.esgi.bibliotheque.service;

import com.esgi.bibliotheque.dto.User.*;
import com.esgi.bibliotheque.entity.User;
import com.esgi.bibliotheque.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto create(CreateUserDto dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Email déjà utilisé.");
        }

        User user = User.builder()
                .prenom(dto.prenom())
                .nom(dto.nom())
                .email(dto.email())
                .typeAbonnement(dto.typeAbonnement())
                .build();

        userRepository.save(user);
        return toDto(user);
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(this::toDto).toList();
    }

    public UserResponseDto findById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        return toDto(user);
    }

    public UserResponseDto update(UUID id, UpdateUserDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        user.setPrenom(dto.prenom());
        user.setNom(dto.nom());
        user.setTypeAbonnement(dto.typeAbonnement());

        userRepository.save(user);
        return toDto(user);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    private UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getPrenom(),
                user.getNom(),
                user.getEmail(),
                user.getTypeAbonnement()
        );
    }
}
