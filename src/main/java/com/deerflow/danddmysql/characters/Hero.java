package com.deerflow.danddmysql.characters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hero {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private HeroType type;
    private Integer lifePoints;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroType getType() {
        return type;
    }

    public void setType(HeroType type) {
        this.type = type;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }
}
