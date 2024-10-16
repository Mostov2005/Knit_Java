package org.knit.lab3;

class Mage extends Player {
    public Mage(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 80;
        this.maxHealth = 80;
        this.isALife = true;
        this.damage = 20;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 10;
        this.energy = 30;
    }

    public void castSpell(Player player) {
        int r = Math.abs(axis_X - player.axis_X) + Math.abs(axis_Y - player.axis_Y);
        if (r > 20) {
            System.out.println("Цель слишком далеко!");
        } else {
            if (energy < 30) {
                System.out.println("Недостаточно энергии");
            } else {
                System.out.println(this.name + " Накладывает заклинание на " + player.name);
                this.energy -= 30;
                player.decreaseHealth(50);
            }
        }
    }
}
