package com.esgi.bibliotheque.patterns.strategy;

import java.time.LocalDate;

public interface EmpruntStrategy {
    LocalDate calculerDateRetour(LocalDate dateEmprunt);
}
