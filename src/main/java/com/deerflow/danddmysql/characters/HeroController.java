package com.deerflow.danddmysql.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/characters/{id}")
    public Optional<Hero> findById(@PathVariable(value = "id") Integer id) {
        return repository.findById(id);
    }

    @DeleteMapping("/characters/{id}")
    public void deleteOne(@PathVariable(value = "id") Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/characters/{id}")
    public Hero editOne(@PathVariable(value = "id") Integer id, @RequestBody Hero hero) {
        Optional<Hero> maybeHero = repository.findById(id);
        maybeHero.ifPresent(oldHero -> hero.setId(oldHero.getId()));
        return repository.save(hero);
    }
}
