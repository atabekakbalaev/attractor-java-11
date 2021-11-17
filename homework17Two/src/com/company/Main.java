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
        whiskas.name = "Whiskas";

        Food kitekat = new Food();
        kitekat.hungerQuenchLevel = 20;
        kitekat.name = "Kitekat";

        System.out.println("State of the cat before being fed:");
        bars.print();

        bars.feed(bars, kitekat );
        bars.feed(bars, whiskas);
        System.out.println("State of the cat after being fed:");
        bars.print();
    }
}
