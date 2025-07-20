package com.esgi.bibliotheque.repository;

import com.esgi.bibliotheque.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpruntRepository extends JpaRepository<Emprunt, UUID> {
}
