package com.deerflow.danddmysql.characters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface HeroRepository extends JpaRepository<Hero, Integer> {
    public List<Hero> findAll();

    public Hero save();

    public Optional<Hero> findById();

    public void deleteById();
}
