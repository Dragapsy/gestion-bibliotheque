package com.esgi.bibliotheque.service;

import com.esgi.bibliotheque.dto.Book.*;
import com.esgi.bibliotheque.entity.Book;
import com.esgi.bibliotheque.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookResponseDto create(CreateBookDto dto) {
        Book book = Book.builder()
                .titre(dto.titre())
                .auteur(dto.auteur())
                .genre(dto.genre())
                .disponible(true)
                .build();
        bookRepository.save(book);
        return toDto(book);
    }

    public List<BookResponseDto> findAll() {
        return bookRepository.findAll().stream().map(this::toDto).toList();
    }

    public BookResponseDto findById(UUID id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livre non trouvé"));
        return toDto(book);
    }

    public BookResponseDto update(UUID id, UpdateBookDto dto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livre non trouvé"));

        book.setTitre(dto.titre());
        book.setAuteur(dto.auteur());
        book.setGenre(dto.genre());
        book.setDisponible(dto.disponible());

        bookRepository.save(book);
        return toDto(book);
    }

    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }

    private BookResponseDto toDto(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getTitre(),
                book.getAuteur(),
                book.getGenre(),
                book.isDisponible()
        );
    }
}
