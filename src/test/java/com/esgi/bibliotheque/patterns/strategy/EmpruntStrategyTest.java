package com.esgi.bibliotheque.patterns.strategy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpruntStrategyTest {

    @Test
    void testEtudiantStrategy() {
        EmpruntContext context = new EmpruntContext();
        context.setStrategy(new EtudiantStrategy());

        LocalDate today = LocalDate.of(2025, 7, 20);
        LocalDate expected = today.plusDays(7);
        assertEquals(expected, context.calculerRetour(today));
    }

    @Test
    void testEnseignantStrategy() {
        EmpruntContext context = new EmpruntContext();
        context.setStrategy(new EnseignantStrategy());

        LocalDate today = LocalDate.of(2025, 7, 20);
        LocalDate expected = today.plusDays(14);
        assertEquals(expected, context.calculerRetour(today));
    }

    @Test
    void testVipStrategy() {
        EmpruntContext context = new EmpruntContext();
        context.setStrategy(new VipStrategy());

        LocalDate today = LocalDate.of(2025, 7, 20);
        LocalDate expected = today.plusDays(30);
        assertEquals(expected, context.calculerRetour(today));
    }
}
