package com.esgi.bibliotheque.patterns.strategy;

import java.time.LocalDate;

public class EnseignantStrategy implements EmpruntStrategy {
    @Override
    public LocalDate calculerDateRetour(LocalDate dateEmprunt) {
        return dateEmprunt.plusDays(14);
    }
}
