package com.esgi.bibliotheque.service;

import com.esgi.bibliotheque.dto.Emprunt.*;
import com.esgi.bibliotheque.entity.Book;
import com.esgi.bibliotheque.entity.Emprunt;
import com.esgi.bibliotheque.entity.User;
import com.esgi.bibliotheque.repository.BookRepository;
import com.esgi.bibliotheque.repository.EmpruntRepository;
import com.esgi.bibliotheque.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public EmpruntResponseDto create(CreateEmpruntDto dto) {
        User user = userRepository.findById(dto.userId()).orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        Book book = bookRepository.findById(dto.bookId()).orElseThrow(() -> new RuntimeException("Livre introuvable"));

        if (!book.isDisponible()) {
            throw new RuntimeException("Le livre n'est pas disponible.");
        }

        book.setDisponible(false);
        bookRepository.save(book);

        Emprunt emprunt = Emprunt.builder()
                .user(user)
                .book(book)
                .dateEmprunt(dto.dateEmprunt())
                .rendu(false)
                .build();

        empruntRepository.save(emprunt);
        return toDto(emprunt);
    }

    public EmpruntResponseDto update(UUID id, UpdateEmpruntDto dto) {
        Emprunt emprunt = empruntRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprunt introuvable"));

        emprunt.setDateRetour(dto.dateRetour());
        emprunt.setRendu(dto.rendu());

        if (dto.rendu()) {
            Book book = emprunt.getBook();
            book.setDisponible(true);
            bookRepository.save(book);
        }

        empruntRepository.save(emprunt);
        return toDto(emprunt);
    }

    public List<EmpruntResponseDto> findAll() {
        return empruntRepository.findAll().stream().map(this::toDto).toList();
    }

    public EmpruntResponseDto findById(UUID id) {
        Emprunt emprunt = empruntRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprunt introuvable"));
        return toDto(emprunt);
    }

    public void delete(UUID id) {
        empruntRepository.deleteById(id);
    }

    private EmpruntResponseDto toDto(Emprunt e) {
        return new EmpruntResponseDto(
                e.getId(),
                e.getUser().getId(),
                e.getBook().getId(),
                e.getDateEmprunt(),
                e.getDateRetour(),
                e.isRendu()
        );
    }
}
