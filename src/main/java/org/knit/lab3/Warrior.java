package org.knit.lab3;

class Warrior extends Player {
    public Warrior(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 52;
        this.maxHealth = 100;
        this.isALife = true;
        this.damage = 40;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 20;
        this.energy = 30;
    }
}
