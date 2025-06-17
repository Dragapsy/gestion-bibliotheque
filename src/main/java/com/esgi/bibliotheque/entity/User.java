package com.esgi.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String prenom;

    private String nom;

    @Column(unique = true, nullable = false)
    private String email;

    private String typeAbonnement;
}
