package com.esgi.bibliotheque.patterns.strategy;

import java.time.LocalDate;

public class EmpruntContext {
    private EmpruntStrategy strategy;

    public void setStrategy(EmpruntStrategy strategy) {
        this.strategy = strategy;
    }

    public LocalDate calculerRetour(LocalDate dateEmprunt) {
        if (strategy == null) {
            throw new IllegalStateException("Aucune stratégie définie");
        }
        return strategy.calculerDateRetour(dateEmprunt);
    }
}
