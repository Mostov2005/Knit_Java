package org.knit.sem1.lab3;

import java.util.Scanner;



public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printRules();

        // Создаем персонажей
        Player[] player1Characters = {
                new Warrior("Орк Игрока 1", -5, 0),
                new Mage("Маг Игрока 1", -10, 10),
                new Priest("Священник Игрока 1", -10, -10)
        };

        Player[] player2Characters = {
                new Warrior("Орк Игрока 2", 5, 0),
                new Mage("Маг Игрока 2", 10, 10),
                new Priest("Священник Игрока 2", 10, -10)
        };

        // Запуск игры
        Game game = new Game(player1Characters, player2Characters, scanner);
        game.start();

        scanner.close();
    }

    public static void printRules() {
        System.out.println("Правила игры:");
        System.out.println("1. У каждого игрока есть три персонажа: Орк, Маг и Священник.");
        System.out.println("2. Каждый персонаж имеет свои индивидуальные характеристики:");
        System.out.println("   - Орк обладает дополнительной защитой.");
        System.out.println("   - Маг владеет мощной атакой магией.");
        System.out.println("   - Священник может восстанавливать здоровье.");
        System.out.println("3. Для передвижения нужно ввести координаты.");
        System.out.println("   Персонаж может перемещаться на любую клетку, если у него достаточно энергии.");
        System.out.println("   Каждое перемещение на одну клетку требует 1 единицу энергии.");
        System.out.println("4. Энергия также требуется для других действий, таких как атака или использование специальных способностей.");
        System.out.println("5. Каждый ход всем персонажам игрока добавляется 20 единиц энергии.");
        System.out.println("6. Цель игры — уничтожить всех вражеских персонажей.");
        System.out.println("7. После каждого хода энергия персонажей восполняется, но максимальный её уровень не может быть превышен.");
    }
}
