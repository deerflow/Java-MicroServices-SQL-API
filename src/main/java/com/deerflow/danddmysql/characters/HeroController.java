package com.deerflow.danddmysql.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {
    @Autowired
    HeroRepository repository;

    @GetMapping("/characters")
    public Iterable<Hero> findAll() {
        return repository.findAll();
    }

    @PostMapping("/characters")
    public int create(@RequestBody Hero hero) {
        Hero savedHero = repository.save(hero);
        return savedHero.getId();
    }
}
