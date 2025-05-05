package org.example;

public class Puppy implements Cutie {
    @Override
    public String description() {
        return "A little puppy with big, sad eyes";
    }

    @Override 
    public Integer cutenessRating() {
        return 11;
    }
}