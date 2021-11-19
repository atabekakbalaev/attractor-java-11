package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int move = 0;
        int[][] damages = new int[2][100];
        Scanner scanner = new Scanner(System.in);
        Hero hero = new Hero(1000, 100, 120, 250, 150);
        Dragon dragon = new Dragon(2000, 120, 150, 120);

        System.out.println("Game started... Initial state of the game:");
        printInfo(move, hero, 0, dragon, 0);

        while(true) {
            if (didHeroWin(dragon)) {
                System.out.println("Hero has won. The end.");
                break;
            }
            if (didDragonWin(hero)) {
                System.out.println("Dragon has won. The end.");
                break;
            }
            move++;
            int amountOfAttackFromHero = heroToDragonAttackAmount(hero, dragon);
            int amountOfAttackFromDragon = dragonToHeroAttackAmount(hero, dragon);
            printInfo(move, hero, amountOfAttackFromHero, dragon, amountOfAttackFromDragon);
        }
    }
    static int dragonToHeroAttackAmount(Hero hero, Dragon dragon) {
        int damage;
        if (new Random().nextInt(2) == 0) {
            damage = dragon.getStrength() + dragon.getWeapon() - hero.getDefense();
            System.out.println("The Dragon has attacked the Hero...");
        } else {
            damage = 0;
            System.out.println("The Dragon didn't attack...");
        }
        int hpLeft = hero.getHealthPoints() - damage;
        int heroHP = Math.max(0, hpLeft);
        hero.setHealthPoints(heroHP);
        return damage;
    }
    static int heroToDragonAttackAmount(Hero hero, Dragon dragon) {
        int damage;
        if (new Random().nextInt(4) > 0) { // 75%, 1,2,3 except 0
            damage = hero.getStrength() + hero.getWeapon() - dragon.getDefense();
            System.out.println("\nThe Hero has attacked the Dragon...");
        } else {
            damage = 0;
            System.out.println("\nThe Hero has missed...");
        }
        int hpLeft = dragon.getHealthPoints() - damage;
        int dragonHP = Math.max(0, hpLeft);
        dragon.setHealthPoints(dragonHP);
        return damage;
    }
    static boolean didDragonWin(Hero hero) {
        return hero.getHealthPoints() == 0;
    }
    static boolean didHeroWin(Dragon dragon) {
        return dragon.getHealthPoints() == 0;
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
