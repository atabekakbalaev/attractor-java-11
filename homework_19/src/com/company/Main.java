package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int move = 0;
        int[][] damages = new int[2][100];
        Scanner scanner = new Scanner(System.in);
        Hero hero = new Hero(1000, 100, 120, 250, 150);
        Dragon dragon = new Dragon(2000, 120, 150, 100);
        int damageToDragon = 0;
        int damageToHero = 0;
        System.out.println("\nGame started... Initial state of the game:");
        printInfo(move, hero, damageToDragon, dragon, damageToHero);
        while(true) {
            if (dragon.getHealthPoints() == 0) {
                System.out.println("\nThe game has ended.");
                break;
            }
            if (new Random().nextInt(4) > 0) { // 75%, 1,2,3 except 0
                damageToDragon = hero.getStrength() + hero.getWeapon() - dragon.getDefense();
                System.out.println("\nThe Hero has hit the dragon...");
            } else {
                damageToDragon = 0;
                System.out.println("\nThe Hero has missed...");
            }
            int hpDragonTemp = dragon.getHealthPoints() - damageToDragon;
            int dragonHP = hpDragonTemp < 0 ? 0 : hpDragonTemp;
            dragon.setHealthPoints(dragonHP);
            move++;
            printInfo(move, hero, damageToDragon, dragon, damageToHero);
        }

    }
    static void printInfo(int move, Hero hero, int damageToDragon, Dragon dragon, int damageToHero) {
        String l1 = "+----+" + "-".repeat(25) + "+" + "-".repeat(16) + "++" +
                "-".repeat(25) + "+" + "-".repeat(16) + "+";
        String header = "|%4s|%25s|%15s ||%25s|%15s |\n";
        System.out.println(l1);
        System.out.printf(header, "Move", "Hero's damage to Dragon", "Hero's HP",
                "Dragon's damage to Hero", "Dragon's HP");
        System.out.println(l1);
        System.out.printf(header, move, damageToDragon, hero.getHealthPoints(),
                damageToHero, dragon.getHealthPoints());
        System.out.println(l1);
    }
}
