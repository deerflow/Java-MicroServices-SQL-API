package com.deerflow.danddmysql.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class HeroController {
    @Autowired
    HeroRepository repository;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
        MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping("/characters")
    public List<Hero> findAll() {
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
