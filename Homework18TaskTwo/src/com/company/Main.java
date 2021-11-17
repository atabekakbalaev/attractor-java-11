package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elevator elevator = new Elevator(1);
        int weight;
        int floor;
        while (true) {
            System.out.println("*".repeat(30));
            System.out.printf("Current floor: %d\n", elevator.getCurrentFloor());
            System.out.print("Enter the floor: ");
            floor = scanner.nextInt();
            System.out.print("Enter the weight: ");
            weight = scanner.nextInt();
            if (elevator.isAllowableFloor(floor) && elevator.isAllowableWeight(weight)) {
                elevator.move(floor);
            }
        }
    }
}
