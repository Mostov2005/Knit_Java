package org.knit.lab11.task24;

import java.sql.SQLException;
import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();


        System.out.println("Список команд:");
        System.out.println("Добавить <имя> <email> - Добавить нового пользователя");
        System.out.println("Список - Показать список всех пользователей");
        System.out.println("Удалить <id> - Удалить пользователя по ID");
        System.out.println("Обновить <id> <новое_имя> <новый_email> - Обновить данные пользователя");
        System.out.println("Выход - Завершить работу программы");


        while (true) {
            System.out.print("Введите команду: ");
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");

            switch (commandParts[0]) {
                case "Добавить":
                    if (commandParts.length == 3) {
                        userService.registerUser(commandParts[1], commandParts[2]);
                    } else {
                        System.out.println("Неверные аргументы. Формат: добавить <имя> <email>");
                    }
                    break;

                case "Список":
                    userService.listAllUsers();
                    break;

                case "Удалить":
                    if (commandParts.length == 2) {
                        try {
                            int id = Integer.parseInt(commandParts[1]);
                            userService.deleteUser(id);
                        } catch (NumberFormatException e) {
                            System.out.println("ID должен быть числом.");
                        }
                    } else {
                        System.out.println("Неверные аргументы. Формат: удалить <id>");
                    }
                    break;

                case "Обновить":
                    if (commandParts.length == 4) {
                        try {
                            int id = Integer.parseInt(commandParts[1]);
                            userService.updateUser(id, commandParts[2], commandParts[3]);
                        } catch (NumberFormatException e) {
                            System.out.println("ID должен быть числом.");
                        }
                    } else {
                        System.out.println("Неверные аргументы. Формат: обновить <id> <новое_имя> <новый_email>");
                    }
                    break;

                case "Выход":
                    System.out.println("Завершение работы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неизвестная команда. Доступные команды: Добавить, Список, Удалить, Обновить, Выход.");
            }
        }
    }
}


//CREATE TABLE IF NOT EXISTS users (
//        id SERIAL PRIMARY KEY,             -- Уникальный идентификатор пользователя
//        name VARCHAR(100) NOT NULL,        -- Имя пользователя
//email VARCHAR(100) NOT NULL UNIQUE -- Email пользователя, уникальное значение
//);

//INSERT INTO users (name, email) VALUES
//('John Doe', 'john.doe@example.com'),
//        ('Jane Smith', 'jane.smith@example.com'),
//        ('Alice Johnson', 'alice.johnson@example.com'),
//        ('Bob Brown', 'bob.brown@example.com'),
//        ('Charlie White', 'charlie.white@example.com')
//ON CONFLICT (email) DO NOTHING;

