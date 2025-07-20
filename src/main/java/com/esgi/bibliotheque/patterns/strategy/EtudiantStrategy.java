package com.esgi.bibliotheque.patterns.strategy;

import java.time.LocalDate;

public class EtudiantStrategy implements EmpruntStrategy {
    @Override
    public LocalDate calculerDateRetour(LocalDate dateEmprunt) {
        return dateEmprunt.plusDays(7);
    }
}
