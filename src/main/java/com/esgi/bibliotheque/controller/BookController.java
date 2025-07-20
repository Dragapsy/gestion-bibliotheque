package com.esgi.bibliotheque.controller;

import com.esgi.bibliotheque.dto.Book.*;
import com.esgi.bibliotheque.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookResponseDto create(@RequestBody @Valid CreateBookDto dto) {
        return bookService.create(dto);
    }

    @GetMapping
    public List<BookResponseDto> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookResponseDto findById(@PathVariable UUID id) {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable UUID id, @RequestBody @Valid UpdateBookDto dto) {
        return bookService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        bookService.delete(id);
    }
}
