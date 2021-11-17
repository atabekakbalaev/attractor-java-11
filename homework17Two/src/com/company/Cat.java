package com.company;

public class Cat {
    String name;
    String breed;
    float age;
    float hungerLevel;

    void feed(Cat cat, Food food) {
        this.hungerLevel -= food.hungerQuenchLevel;
    }
    void print() {
        String s = "%s has hunger quench level %.2f\n";
        System.out.format(s, this.name, this.hungerLevel);
    }
}
