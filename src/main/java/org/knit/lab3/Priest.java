package org.knit.lab3;

class Priest extends Player {
    public Priest(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 60;
        this.maxHealth = 60;
        this.isALife = true;
        this.damage = 10;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 5;
        this.energy = 30;
    }

    public void heal(Player player) {
        System.out.println(this.name + " Лечит " + player.name);
        this.energy -= 30;
        player.addHealth(30);

    }
}
