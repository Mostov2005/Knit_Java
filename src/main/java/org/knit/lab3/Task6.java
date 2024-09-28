package org.knit.lab3;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player warrior = new Warrior("Some Ork", 52, 100, true, 25, 10, 15, 40);
        Player mage = new Mage("Some Mage", 30, 80, true, 50, 10, 15, 15);
        Player priest = new Priest("Some Healer", 60, 60, true, 25, 0, 0, 25);

        System.out.println("До атаки: ");
        System.out.println(warrior.currentHealth);

        mage.attack(warrior);
        System.out.println("После атаки: ");
        System.out.println(warrior.currentHealth);

        priest.heal(warrior);

        System.out.println("После лечения: ");
        System.out.println(warrior.currentHealth);

        warrior.attack(mage);
//
//        mage.castSpell(warrior);


    }
}

abstract class Player {
    protected String name;
    protected double currentHealth;
    protected double maxHealth;
    protected boolean isALife;
    protected double damage;
    protected int axis_X;
    protected int axis_Y;
    protected double protection;


    public abstract void addHealth(int healPower);

    public abstract void attack(Player player);

    public abstract void decreaseHealth(double value);

    public abstract void heal(Player warrior);
}

class Mage extends Player {
    public Mage(String name, double currentHealth, double maxHealth, boolean isALife, double damage, int axis_X, int axis_Y, double protection) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.isALife = isALife;
        this.damage = damage;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = protection;
    }

    @Override
    public void attack(Player player) {
        System.out.println(this.name + " атакует " + player.name);
        player.decreaseHealth(this.damage);
    }

    @Override
    public void decreaseHealth(double value) {
        this.currentHealth -= Math.max(value - this.protection, 0);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
        if (currentHealth < 0) {
            isALife = false;
            System.out.println(this.name + " мёртв");
        }
    }

    @Override
    public void addHealth(int healPower) {
        currentHealth = Math.min(this.maxHealth, currentHealth + healPower);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
    }

    @Override
    public void heal(Player player) {
        System.out.println(this.name + " Лечит " + player.name);
        player.addHealth(10);
    }

}

class Warrior extends Player {

    public Warrior(String name, double currentHealth, double maxHealth, boolean isALife, double damage, int axis_X, int axis_Y, double protection) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.isALife = isALife;
        this.damage = damage;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = protection;
    }

    @Override
    public void heal(Player player) {
        System.out.println(this.name + " Лечит " + player.name);
        player.addHealth(5);
    }

    @Override
    public void addHealth(int healPower) {
        currentHealth = Math.min(this.maxHealth, currentHealth + healPower);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
    }

    @Override
    public void attack(Player player) {
        System.out.println(this.name + " атакует " + player.name);
        player.decreaseHealth(this.damage);
    }


    @Override
    public void decreaseHealth(double value) {
        int additionalDefence = 5;
        this.currentHealth -= Math.max(value - additionalDefence - this.protection, 0);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
        if (currentHealth < 0) {
            isALife = false;
            System.out.println(this.name + " мёртв");
        }
    }


}

class Priest extends Player {
    public Priest(String name, double currentHealth, double maxHealth, boolean isALife, double damage, int axis_X, int axis_Y, double protection) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.isALife = isALife;
        this.damage = damage;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = protection;
    }


    @Override
    public void addHealth(int healPower) {
        currentHealth = Math.min(this.maxHealth, currentHealth + healPower);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
    }

    @Override
    public void attack(Player player) {
        System.out.println(this.name + " атакует " + player.name);
        player.decreaseHealth(this.damage);
    }


    @Override
    public void decreaseHealth(double value) {
        this.currentHealth -= Math.max(value - this.protection, 0);
        System.out.println("Текущее здоровье " + this.name + " = " + currentHealth);
        if (currentHealth < 0) {
            isALife = false;
            System.out.println(this.name + " мёртв");
        }
    }

    public void heal(Player player) {
        System.out.println(this.name + " Лечит " + player.name);
        player.addHealth(30);
    }
}