package org.example;

public class Kitty implements Cutie {
    @Override
    public String description() {
        return "A fluffy kitten playing with yarn";
    }

    @Override
    public Integer cutenessRating() {
        return 10;
    }
}