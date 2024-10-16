package org.knit.lab3;

public abstract class Player {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;
    protected boolean isALife;
    protected int damage;
    protected int axis_X;
    protected int axis_Y;
    protected int protection;
    protected int energy;

    public void displayInfo() {
        System.out.print(name + ":");
        System.out.print(" Живой: " + (isALife ? "Да" : "Нет"));
        System.out.print("; Текущее здоровье: " + currentHealth + "/" + maxHealth);
        System.out.print("; Урон: " + damage);
        System.out.print("; Защита: " + protection);
        System.out.print("; Энергия: " + energy + "/100");
        System.out.println("; Координаты: X = " + axis_X + ", Y = " + axis_Y);
    }

    protected void attack(Player player) {
        int r = Math.abs(axis_X - player.axis_X) + Math.abs(axis_Y - player.axis_Y);
        if (r > 5) {
            System.out.println("Цель слишком далеко!");
        } else {
            if (energy < 30) {
                System.out.println("Недостаточно энергии");
            } else {
                System.out.println(this.name + " атакует " + player.name);
                energy -= 30;
                player.decreaseHealth(this.damage);
            }
        }
    }

    protected void addHealth(int healPower) {
        currentHealth = Math.min(this.maxHealth, currentHealth + healPower);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
    }

    protected void decreaseHealth(int value) {
        this.currentHealth -= Math.max(value - protection, 0);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
        if (currentHealth < 0) {
            isALife = false;
            System.out.println(this.name + " мёртв");
        }
    }

    protected void move(int x, int y) {
        int r = Math.abs(axis_X - x) + Math.abs(axis_Y - y);
        if (r > energy) {
            System.out.println("Недостаточно энергии!");
        } else {
            axis_X = x;
            axis_Y = y;
            energy -= r;
            System.out.println(name + " Передвигается на: X = " + axis_X + ",Y = " + axis_Y);
        }
    }

    protected void addEnergy() {
        energy += 20;
    }
}