package com.company;

public class Cat {
    String name;
    String breed;
    float age;
    float hungerLevel;
    float thirstLevel;

    void feed(Cat cat, Food food) {
        if (cat.thirstLevel > 0) {
            System.out.println("You cannot feed the cat unless its thirsty.");
        } else {
            cat.thirstLevel -= food.thirstQuenchLevel;
            cat.hungerLevel -= food.hungerQuenchLevel;
        }
    }

    void print() {
        String s = "%s has hunger quench level %.2f\n";
        System.out.format(s, this.name, this.hungerLevel);
    }
}
