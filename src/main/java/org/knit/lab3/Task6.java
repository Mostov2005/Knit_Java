package org.knit.lab3;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Правила игры:");
        System.out.println("У каждого игрока есть три персонажа: Орк, Маг, Священник.");
        System.out.println("Характеристики каждого персонажа индивидуальны, например, у Орка больше всео здоровья.");
        System.out.println("Каждый персонаж умеет передвигаться и атаковать.");
        System.out.println("Для выполнения каждого действия, персонажу нужна энергия.");
        System.out.println("За один ход можно управлять только одним персонажем.");
        System.out.println("После завершения хода игрока у каждого его персонажа восполняется энергия.");
        System.out.println("Цель игры - убить всех вражеских перонажей");


        Warrior warrior1 = new Warrior("Орк игрока 1", 0, 0);
        Mage mage1 = new Mage("Маг игрока 1", 100, 100);
        Priest priest1 = new Priest("Священник игрока 1", -10, -10);

        Warrior warrior2 = new Warrior("Орк игрока 2", 0, 0);
        Mage mage2 = new Mage("Маг игрока 2", 100, 100);
        Priest priest2 = new Priest("Священник игрока 2", -10, -10);

//        String[] сharacters = {warrior1, mage1, priest1, warrior2, mage2, priest2};
//
//        public static void infoPers (String[]array){
//            System.out.println("sd");
//        }

//        warrior.displayInfo();
//        mage.displayInfo();
//        warrior.attack(mage);
//        mage.movement(100, 100);

//        mage.attack(warrior);
//
//        warrior.attack(mage);
//
//        mage.castSpell(warrior);
//
//        priest.heal(warrior);
    }
}

abstract class Player {
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
        System.out.println("=".repeat(250));
        System.out.print(name + ":");
        System.out.print(" Живой: " + (isALife ? "Да" : "Нет"));
        System.out.print("; Текущее здоровье: " + currentHealth + "/" + maxHealth);
        System.out.print("; Урон: " + damage);
        System.out.print("; Защита: " + protection);
        System.out.print("; Энергия: " + energy + "/100");
        System.out.println("; Координаты: X = " + axis_X + ", Y = " + axis_Y);
        System.out.println("=".repeat(250));
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

    protected void movement(int x, int y) {
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

class Mage extends Player {
    public Mage(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 80;
        this.maxHealth = 80;
        this.isALife = true;
        this.damage = 50;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 15;
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

class Warrior extends Player {
    public Warrior(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 52;
        this.maxHealth = 100;
        this.isALife = true;
        this.damage = 25;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 40;
        this.energy = 30;
    }
}

class Priest extends Player {
    public Priest(String name, int axis_X, int axis_Y) {
        this.name = name;
        this.currentHealth = 60;
        this.maxHealth = 60;
        this.isALife = true;
        this.damage = 25;
        this.axis_X = axis_X;
        this.axis_Y = axis_Y;
        this.protection = 25;
        this.energy = 30;
    }

    public void heal(Player player) {
        System.out.println(this.name + " Лечит " + player.name);
        this.energy -= 30;
        player.addHealth(30);

    }
}