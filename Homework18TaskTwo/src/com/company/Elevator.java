package com.company;

import java.util.Random;
import java.util.Scanner;

public class Elevator {
    private int currentFloor;
    private int capacity;
    private int maxFloor;

    public Elevator(int currentFloor) {
        this.capacity = 200;
        this.currentFloor = currentFloor;
        this.maxFloor = 18;
    }

    public boolean isAllowableWeight(int weight) {
        return weight <= this.capacity && weight > 0 ? true : false;
    }

    public boolean isAllowableFloor(int floor) {
        return floor <= this.maxFloor && floor > 0 ? true : false;
    }

    public void move(int toFloor) {
        int step = toFloor > this.currentFloor ? 1 : -1;
        while (this.currentFloor != toFloor) {
            boolean probability = new Random().nextInt(3) == 0;
//            System.out.println("The elevator is broken " + probability);
            if (probability) {
                System.out.print("The elevator has stuck... Do you want to fix it? y or n: ");
                char option = new Scanner(System.in).nextLine().charAt(0);
                switch (option) {
                    case 'y':
                        System.out.println("The technician is coming...please wait...");
                        System.out.println("The technician has fixed the elevator...");
                        System.out.printf("%s floor %d %s\n", "-".repeat(5), this.currentFloor, "-".repeat(5));
                        this.currentFloor += step;
                        break;
                    case 'n':
                        System.out.println("The elevator is out of order. Please call 911...");
                        System.exit(0);
                        break;
                }
            } else {
                System.out.printf("%s floor %d %s\n", "-".repeat(5), this.currentFloor, "-".repeat(5));
                this.currentFloor += step;
            }
        }
        System.out.printf("%s floor %d %s\n", "-".repeat(5), this.currentFloor, "-".repeat(5));
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }
}
