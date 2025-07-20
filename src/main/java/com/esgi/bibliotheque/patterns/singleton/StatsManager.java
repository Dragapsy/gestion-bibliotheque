package com.esgi.bibliotheque.patterns.singleton;

public class StatsManager {

    private static StatsManager instance;

    private int booksCreated = 0;
    private int empruntsCreated = 0;

    private StatsManager() {}

    public static StatsManager getInstance() {
        if (instance == null) {
            instance = new StatsManager();
        }
        return instance;
    }

    public void reset() {
        booksCreated = 0;
        empruntsCreated = 0;
    }

    public void incrementBooks() {
        booksCreated++;
    }

    public void incrementEmprunts() {
        empruntsCreated++;
    }

    public int getBooksCreated() {
        return booksCreated;
    }

    public int getEmpruntsCreated() {
        return empruntsCreated;
    }
}
