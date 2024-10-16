package org.knit.lab3;

import java.util.Scanner;

public class Game {
    private Player[] player1Characters;
    private Player[] player2Characters;
    private Scanner scanner;
    private boolean gameRunning = true; // Переменная для управления состоянием игры
    private int currentPlayer = 1; // Переменная, определяющая, чей ход (1 или 2)

    public Game(Player[] player1Characters, Player[] player2Characters, Scanner scanner) {
        this.player1Characters = player1Characters;
        this.player2Characters = player2Characters;
        this.scanner = scanner;

    }

    // Метод для запуска игры
    public void start() {
        System.out.println("Начало игры! Игрок 1 ходит первым.");
        while (gameRunning) {
            CharacterChart chart = new CharacterChart(player1Characters, player2Characters);
            chart.display();  // Отображаем график для первой команды
            displayPlayerInfo(); // Отображение информации о персонажах
            Player[] currentTeam = (currentPlayer == 1) ? player1Characters : player2Characters; // Определяем текущую команду
            Player selectedCharacter = selectCharacter(currentTeam); // Выбор персонажа

            if (selectedCharacter != null) {
                performActions(selectedCharacter, currentTeam); // Выполнение действий выбранного персонажа
            }
            chart.updateChart(player1Characters, player2Characters);
            // Проверка на конец игры
            gameRunning = !isTeamDefeated(player1Characters) && !isTeamDefeated(player2Characters);
            restoreEnergy(currentTeam); // Восстановление энергии у персонажей текущей команды
            currentPlayer = (currentPlayer == 1) ? 2 : 1; // Переход к следующему игроку
        }
        System.out.println("Игра окончена!");
    }

    // Метод для выбора персонажа из команды
    private Player selectCharacter(Player[] team) {
        Player selectedCharacter = null; // Переменная для хранения выбранного персонажа
        while (selectedCharacter == null) {
            System.out.println("Выберите персонажа:");
            for (int i = 0; i < team.length; i++) {
                // Отображение информации о персонажах команды
                System.out.println((i + 1) + ". " + team[i].name + "; Энергия: " + team[i].energy + "; Здоровье: " + team[i].currentHealth);
            }
            // Проверка ввода числа от пользователя
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt() - 1; // Получение выбора пользователя
                if (choice >= 0 && choice < team.length) {
                    selectedCharacter = team[choice]; // Установка выбранного персонажа
                } else {
                    System.out.println("Неверный выбор, попробуйте снова.");
                    scanner.next();
                }
            } else {
                System.out.println("Пожалуйста, введите число.");
                scanner.next();
            }
        }
        return selectedCharacter; // Возвращаем выбранного персонажа
    }

    // Метод для выполнения действий выбранного персонажа
    private void performActions(Player character, Player[] team) {
        boolean characterTurn = true; // Переменная для управления ходом персонажа
        while (characterTurn && character.energy > 0) { // Пока у персонажа есть энергия
            System.out.println("Текущая энергия игрока " + character.name + ": " + character.energy);
            System.out.println("Выберите действие (или введите 0 для завершения хода):");
            System.out.println("1. Перемещение");
            System.out.println("2. Атака (Нужно 30 энергии)");

            // Если персонаж - маг или священник, показываем дополнительные действия
            if (character instanceof Mage) {
                System.out.println("3. Наложить заклинание");
            } else if (character instanceof Priest) {
                System.out.println("3. Исцелить");
            }

            int action = scanner.hasNextInt() ? scanner.nextInt() : -1; // Получение действия от пользователя
            if (action == 0) break; // Завершение хода

            switch (action) {
                case 1: // Перемещение персонажа
                    System.out.println("Введите новые координаты X и Y:");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    character.move(x, y);
                    break;

                case 2: // Атака
                    attackEnemy(character);
                    break;

                case 3: // Дополнительный навык
                    if (character instanceof Mage) {
                        castSpell((Mage) character); // Если маг, вызываем заклинание
                    } else if (character instanceof Priest) {
                        healAlly((Priest) character); // Если священник, исцеляем союзника
                    }
                    break;
                default:
                    System.out.println("Неверное действие, попробуйте снова."); // Ошибка при неправильном действии
                    scanner.next();
            }
        }
    }

    // Метод для атаки врага
    private void attackEnemy(Player attacker) {
        Player[] enemyTeam = (currentPlayer == 1) ? player2Characters : player1Characters; // Определяем команду врага
        System.out.println("Выберите цель для атаки:");
        Player target = selectTarget(enemyTeam); // Выбор цели
        if (target != null) {
            attacker.attack(target); // Атака цели
        }
    }

    // Метод для заклинания
    private void castSpell(Mage mage) {
        Player[] enemyTeam = (currentPlayer == 1) ? player2Characters : player1Characters; // Определяем команду врага
        System.out.println("Выберите цель для заклинания:");
        Player target = selectTarget(enemyTeam); // Выбор цели
        if (target != null) {
            mage.castSpell(target); // Применение заклинания
        }
    }

    // Метод для исцеления союзника
    private void healAlly(Priest priest) {
        Player[] team = (currentPlayer == 1) ? player1Characters : player2Characters; // Определяем команду союзника
        System.out.println("Выберите цель для исцеления:");
        Player target = selectTarget(team); // Выбор цели
        if (target != null) {
            priest.heal(target); // Исцеление цели
        }
    }

    // Метод для выбора цели атаки или исцеления
    private Player selectTarget(Player[] team) {
        for (int i = 0; i < team.length; i++) {
            // Отображение информации о персонажах команды
            System.out.println((i + 1) + ". " + team[i].name + "; Энергия: " + team[i].energy + "; Здоровье: " + team[i].currentHealth);
        }
        int choice = scanner.nextInt() - 1; // Получение выбора пользователя
        return (choice >= 0 && choice < team.length) ? team[choice] : null; // Возврат выбранной цели
    }

    // Метод для восстановления энергии у команды
    private void restoreEnergy(Player[] team) {
        for (Player player : team) {
            player.addEnergy(); // Восстановление энергии каждого персонажа
        }
    }

    // Проверка на наличие живых игроков команды
    private boolean isTeamDefeated(Player[] team) {
        for (Player character : team) {
            if (character.isALife) {
                return false;
            }
        }
        return true; // Если все персонажи мертвы, команда повержена
    }

    private void displayPlayerInfo() {
        System.out.println();
        System.out.println("Информация об игроках:");
        for (Player player : player1Characters) {
            player.displayInfo();
        }
        System.out.println("=".repeat(50));
        for (Player player : player2Characters) {
            player.displayInfo();
        }
        System.out.println();
    }
}
