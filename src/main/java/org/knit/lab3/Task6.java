package org.knit.lab3;

import java.util.Scanner;

//System.out.println((i + 1) + ". " + characters[i].name + " (Энергия: " + characters[i].energy + ")");


public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Правила игры:");
        System.out.println("У каждого игрока есть три персонажа: Орк, Маг, Священник.");
        System.out.println("Характеристики каждого персонажа индивидуальны, например, у Орка больше всего здоровья.");
        System.out.println("Каждый персонаж умеет передвигаться и атаковать.");
        System.out.println("Для выполнения каждого действия персонажу нужна энергия.");
        System.out.println("После каждого хода, у всех игроков восполняется энергия.");
        System.out.println("Цель игры - убить всех вражеских персонажей");

        // Создаем персонажей
        Player[] player1Characters = {
                new Warrior("Орк Игрока 1", 10, 10),
                new Mage("Маг Игрока 1", 5, 5),
                new Priest("Священник Игрока 1", 0, 0)
        };

        Player[] player2Characters = {
                new Warrior("Орк Игрока 2", 20, 20),
                new Mage("Маг Игрока 2", 25, 25),
                new Priest("Священник Игрока 2", 30, 30)
        };

        // Запуск игры
        Game game = new Game(player1Characters, player2Characters, scanner);
        game.start();

        scanner.close();
    }
}


//        Class[] сharacters = {warrior1, mage1, priest1, warrior2, mage2, priest2};
//
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