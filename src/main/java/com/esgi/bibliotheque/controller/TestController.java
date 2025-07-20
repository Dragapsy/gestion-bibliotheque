package com.esgi.bibliotheque.controller;

import com.esgi.bibliotheque.entity.Book;
import com.esgi.bibliotheque.entity.Emprunt;
import com.esgi.bibliotheque.entity.User;
import com.esgi.bibliotheque.patterns.factory.BookFactory;
import com.esgi.bibliotheque.patterns.factory.EmpruntFactory;
import com.esgi.bibliotheque.patterns.factory.UserFactory;
import com.esgi.bibliotheque.patterns.singleton.StatsManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/factory")
    public Emprunt createSampleEmprunt() {
        User user = UserFactory.createDefaultUser();
        Book book = BookFactory.createDefaultBook();
        return EmpruntFactory.createDefaultEmprunt(user, book);
    }

    @GetMapping("/singleton/stats")
    public ResponseEntity<?> getStats() {
        StatsManager stats = StatsManager.getInstance();
        Map<String, Integer> result = new HashMap<>();
        result.put("booksCreated", stats.getBooksCreated());
        result.put("empruntsCreated", stats.getEmpruntsCreated());
        return ResponseEntity.ok(result);
    }
}
