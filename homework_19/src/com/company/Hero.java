package com.company;

public class Hero extends PlayerType {
    private int shield;

    public Hero(int healthPoints, int strength, int defense, int weapon, int shield) {
        super(healthPoints, strength, defense, weapon);
        this.shield = shield;
    }
    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
}
