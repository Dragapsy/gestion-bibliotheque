package com.esgi.bibliotheque.patterns.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatsManagerTest {

    @BeforeEach
    void resetStats() {
        // Reset via réflexion ou recréation si nécessaire
        StatsManager.getInstance().reset();
    }

    @Test
    void shouldIncrementBooksAndEmprunts() {
        StatsManager stats = StatsManager.getInstance();

        stats.incrementBooks();
        stats.incrementBooks();
        stats.incrementEmprunts();

        assertEquals(2, stats.getBooksCreated());
        assertEquals(1, stats.getEmpruntsCreated());
    }

    @Test
    void instanceShouldBeSingleton() {
        StatsManager instance1 = StatsManager.getInstance();
        StatsManager instance2 = StatsManager.getInstance();

        assertSame(instance1, instance2);
    }
}
