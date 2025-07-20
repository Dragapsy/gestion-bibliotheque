package com.esgi.bibliotheque.controller;

import com.esgi.bibliotheque.dto.Emprunt.*;
import com.esgi.bibliotheque.service.EmpruntService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/emprunts")
@RequiredArgsConstructor
public class EmpruntController {

    private final EmpruntService empruntService;

    @PostMapping
    public EmpruntResponseDto create(@RequestBody @Valid CreateEmpruntDto dto) {
        return empruntService.create(dto);
    }

    @PutMapping("/{id}")
    public EmpruntResponseDto update(@PathVariable UUID id, @RequestBody @Valid UpdateEmpruntDto dto) {
        return empruntService.update(id, dto);
    }

    @GetMapping
    public List<EmpruntResponseDto> findAll() {
        return empruntService.findAll();
    }

    @GetMapping("/{id}")
    public EmpruntResponseDto findById(@PathVariable UUID id) {
        return empruntService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        empruntService.delete(id);
    }
}
