package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int move = 0;
        String enemy;
        Hero hero = new Hero(1000, 100, 120, 250, 100);
        Dragon dragon = new Dragon(1400, 150, 150, 120);
        Hellhound hellhound = new Hellhound(1200, 120, 100, 150);

        System.out.println("Game started... Initial state of the game:");
        if (new Random().nextInt(2) == 0) {
            enemy = "dragon";
            System.out.println("Dragon was chosen by the computer.");
            printInfo(move, hero, 0, dragon, 0);
        } else {
            enemy = "hellhound";
            System.out.println("Hellhound was chosen by the computer.");
            printInfo(move, hero, 0, hellhound, 0);
        }

        while(true) {
            if (didHellhoundWin(hero)) {
                System.out.println("Hellhound has won. The end.");
            }
            if (didHeroWin(dragon)) {
                System.out.println("Hero has won. The end.");
                break;
            }
            if (didDragonWin(hero)) {
                System.out.println("Dragon has won. The end.");
                break;
            }
            move++;
            char userAction = getUserAction();
            if (enemy.equals("dragon")) {
                int amountOfAttackFromHero = heroToDragonAttackAmount(hero, dragon, userAction);
                int amountOfAttackFromDragon = dragonToHeroAttackAmount(hero, dragon, userAction);
                printInfo(move, hero, amountOfAttackFromHero, dragon, amountOfAttackFromDragon);
            } else {
                int amountOfAttackFromHero = heroToHellhoundAttackAmount(hero, hellhound, userAction);
                int amountOfAttackFromHellhound = hellhoundToHeroAttackAmount(hero, hellhound, userAction);
                printInfo(move, hero, amountOfAttackFromHero, hellhound, amountOfAttackFromHellhound);
            }
        }
    }
    static char getUserAction() {
        Scanner scanner = new Scanner(System.in);
        char option = '0';
        while(!(option == 'a' || option == 'n' || option == 'd')) {
            System.out.println("Choose from the following actions for the Hero: ");
            System.out.println("a - attack\nn - nothing\nd - defense");
            System.out.print("Your choice: ");
            option = scanner.nextLine().charAt(0);
        }
        return option;
    }
    static int hellhoundToHeroAttackAmount(Hero hero, Hellhound hellhound, char action) {
        int damage = 0;
        int shield = action == 'd' ? hero.getShield() : 0;
        if (new Random().nextInt(2) == 0) {
            damage = hellhound.getStrength() + hellhound.getWeapon() - (hero.getDefense() + shield);
            System.out.println("The Hellhound has attacked the Hero...");
        } else {
            System.out.println("The Hellhound didn't attack...");
        }
        damage = Math.max(0, damage);
        int hpLeft = hero.getHealthPoints() - damage;
        int heroHP = Math.max(0, hpLeft);
        hero.setHealthPoints(heroHP);
        return damage;
    }
    static int dragonToHeroAttackAmount(Hero hero, Dragon dragon, char action) {
        int damage = 0;
        int shield = action == 'd' ? hero.getShield() : 0;
        int fireball = 1;
        if (new Random().nextInt(2) == 0) {
            if (new Random().nextInt(2) == 0) {
                damage = dragon.getStrength() * 2 * (shield > 0 ? 0 : 1);
                System.out.println("Dragon has used fireball...");
            } else {
                damage = dragon.getStrength() + dragon.getWeapon() - (hero.getDefense() + shield);
                System.out.println("The Dragon has attacked the Hero...");
            }
        } else {
            System.out.println("The Dragon didn't attack...");
        }
        damage = Math.max(0, damage);
        int hpLeft = hero.getHealthPoints() - damage;
        int heroHP = Math.max(0, hpLeft);
        hero.setHealthPoints(heroHP);
        return damage;
    }
    static int heroToHellhoundAttackAmount(Hero hero, Hellhound hellhound, char action) {
        int damage = 0;
        switch (action) {
            case 'a':
                if (new Random().nextInt(4) > 0) { // 75%, 1,2,3 except 0
                    damage = hero.getStrength() + hero.getWeapon() - hellhound.getDefense();
                    System.out.println("\nThe Hero has attacked the Hellhound...");
                } else {
                    System.out.println("\nThe Hero has missed...");
                }
                break;
            case 'n':
                System.out.println("\nThe Hero has chosen to do nothing...");
                break;
            case 'd':
                System.out.println("\nThe Hero is holding the shield...");
        }
        damage = Math.max(0, damage);
        int hpLeft = hellhound.getHealthPoints() - damage;
        int dragonHP = Math.max(0, hpLeft);
        hellhound.setHealthPoints(dragonHP);
        return damage;
    }
    static int heroToDragonAttackAmount(Hero hero, Dragon dragon, char action) {
        int damage = 0;
        switch (action) {
            case 'a':
                if (new Random().nextInt(4) > 0) { // 75%, 1,2,3 except 0
                    damage = hero.getStrength() + hero.getWeapon() - dragon.getDefense();
                    System.out.println("\nThe Hero has attacked the Dragon...");
                } else {
                    System.out.println("\nThe Hero has missed...");
                }
                break;
            case 'n':
                System.out.println("\nThe Hero has chosen to do nothing...");
                break;
            case 'd':
                System.out.println("\nThe Hero is holding the shield...");
        }
        damage = Math.max(0, damage);
        int hpLeft = dragon.getHealthPoints() - damage;
        int dragonHP = Math.max(0, hpLeft);
        dragon.setHealthPoints(dragonHP);
        return damage;
    }
    static boolean didHellhoundWin(Hero hero) {
        return hero.getHealthPoints() == 0;
    }
    static boolean didDragonWin(Hero hero) {
        return hero.getHealthPoints() == 0;
    }
    static boolean didHeroWin(Dragon dragon) {
        return dragon.getHealthPoints() == 0;
    }
    static void printInfo(int move, Hero hero, int damageToHellhound, Hellhound hellhound, int damageToHero) {
        String l1 = "+----+" + "-".repeat(28) + "+" + "-".repeat(16) + "++" +
                "-".repeat(28) + "+" + "-".repeat(16) + "+";
        String header = "|%4s|%28s|%15s ||%28s|%15s |\n";
        System.out.println(l1);
        System.out.printf(header, "Move", "Hero's damage to Hellhound", "Hero's HP",
                "Hellhound's damage to Hero", "Hellhound's HP");
        System.out.println(l1);
        System.out.printf(header, move, damageToHellhound, hero.getHealthPoints(),
                damageToHero, hellhound.getHealthPoints());
        System.out.println(l1);
    }
    static void printInfo(int move, Hero hero, int damageToDragon, Dragon dragon, int damageToHero) {
        String l1 = "+----+" + "-".repeat(28) + "+" + "-".repeat(16) + "++" +
                "-".repeat(28) + "+" + "-".repeat(16) + "+";
        String header = "|%4s|%28s|%15s ||%28s|%15s |\n";
        System.out.println(l1);
        System.out.printf(header, "Move", "Hero's damage to Dragon", "Hero's HP",
                "Dragon's damage to Hero", "Dragon's HP");
        System.out.println(l1);
        System.out.printf(header, move, damageToDragon, hero.getHealthPoints(),
                damageToHero, dragon.getHealthPoints());
        System.out.println(l1);
    }
}
