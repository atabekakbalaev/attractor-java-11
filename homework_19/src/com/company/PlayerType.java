package com.company;

public class PlayerType {
    private int healthPoints;
    private int strength;
    private int defense;
    private int weapon;

    public PlayerType(int healthPoints, int defense, int strength, int weapon) {
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.defense = defense;
        this.weapon = weapon;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getWeapon() {
        return weapon;
    }
}
