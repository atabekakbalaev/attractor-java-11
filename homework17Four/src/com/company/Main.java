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

        Food whiskas = new Food();
        whiskas.hungerQuenchLevel = 80;
        whiskas.name = "Whiskas";

        Food atala = new Food();
        atala.hungerQuenchLevel = 20;
        atala.name = "Atala";

        System.out.println("State of the cat before being fed:");
        bars.print();
        System.out.println("The desired hunger level " + desiredHungerLevel );

        if (bars.hungerLevel < desiredHungerLevel) {
            System.out.println("Cat should sit on a diet");
        }
        while(bars.hungerLevel > desiredHungerLevel) {
            System.out.println("Enter the food number");
            System.out.printf("1 for %s and 2 for %s: ", atala.name, whiskas.name);
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    bars.hungerLevel -= atala.hungerQuenchLevel;
                    break;
                case 2:
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
