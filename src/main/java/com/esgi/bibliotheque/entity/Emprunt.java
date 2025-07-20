package com.esgi.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "emprunt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emprunt {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Book book;

    @Column(nullable = false)
    private LocalDate dateEmprunt;

    private LocalDate dateRetour;

    private boolean rendu;
}
