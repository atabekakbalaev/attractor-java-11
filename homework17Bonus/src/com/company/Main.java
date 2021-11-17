package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int hungerLevel = random.nextInt(100) + 1;
        int desiredHungerLevel = random.nextInt(100) + 1;
        Cat bars = new Cat();
        bars.name = "Bars";
        bars.age = 2;
        bars.breed = "Turkish Van";
        bars.hungerLevel = hungerLevel;
        bars.thirstLevel = 0;

        Food[] food = new Food[2];

        Food whiskas = new Food();
        whiskas.hungerQuenchLevel = 80;
        whiskas.name = "Whiskas";

        Food atala = new Food();
        atala.hungerQuenchLevel = 20;
        atala.name = "Atala";

        food[0] = whiskas;
        food[1] = atala;

        System.out.println("State of the cat before being fed:");
        bars.print();
        System.out.println("The desired hunger level " + desiredHungerLevel);

        if (bars.hungerLevel < desiredHungerLevel) {
            System.out.println("Cat should sit on a diet");
        }
        while(bars.hungerLevel > desiredHungerLevel) {
            int choice = new Random().nextInt(food.length);
            System.out.printf("The program chooses a random number: %d\n", choice);
            System.out.printf("%s has been chosen randomly chosen.\n", food[choice].name);
            switch (choice) {
                case 0:
                    bars.hungerLevel -= atala.hungerQuenchLevel;
                    break;
                case 1:
                    bars.hungerLevel -= whiskas.hungerQuenchLevel;
                    break;
                default:
                    System.out.println("There is no such choice.");
            }
            if (bars.hungerLevel == desiredHungerLevel) {
                System.out.println("The cat is full.");
            } else if (bars.hungerLevel < desiredHungerLevel) {
                System.out.println("The cat has been overfed.");
            }
            bars.print();

        }
    }
}
