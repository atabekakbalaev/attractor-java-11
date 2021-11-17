package com.company;

public class Main {

    public static void main(String[] args) {
        Cat bars = new Cat();
        bars.name = "Bars";
        bars.age = 2;
        bars.breed = "Turkish Van";
        bars.hungerLevel = 80;

        Food whiskas = new Food();
        whiskas.hungerQuenchLevel = 30;
        whiskas.thirstQuenchLevel = -10;
        whiskas.name = "Whiskas";

        Food atala = new Food();
        atala.hungerQuenchLevel = 20;
        atala.thirstQuenchLevel = 50;
        atala.name = "Atala";

        System.out.println("State of the cat before being fed:");
        bars.print();

        bars.feed(bars, whiskas);
        System.out.printf("State of the cat after being fed with %s:\n", whiskas.name);
        bars.print();

        System.out.println("Let's feed the cat again!");
        bars.feed(bars, whiskas);
        bars.print();
    }
}
