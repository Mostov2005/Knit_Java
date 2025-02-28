package org.knit.lab11Kakovkin.task24;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) {
        System.out.println("Старт программы...");
        UserDAO userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);

        Scanner scanner = new Scanner(System.in);
        String selectedOption = "";

        while (!selectedOption.equals("5")) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Обновить пользователя");
            System.out.println("4. Удалить пользователя");
            System.out.println("5. Выйти из программы");

            System.out.println("\nВыберите опцию: ");
            selectedOption = scanner.nextLine();

            try {
                switch (selectedOption) {
                    case "1":
                        System.out.println("Введите имя пользователя: ");
                        String name = scanner.nextLine();
                        System.out.println("Введите email пользователя: ");
                        String email = scanner.nextLine();
                        userService.registerUser(name, email);
                        break;

                    case "2":
                        System.out.println("Список пользователей:");
                        List<User> users = userService.listAllUsers();
                        users.forEach(System.out::println);
                        break;

                    case "3":
                        System.out.println("Введите id пользователя: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Введите новое имя пользователя: ");
                        String newName = scanner.nextLine();
                        System.out.println("Введите новый email пользователя: ");
                        String newEmail = scanner.nextLine();
                        userService.updateUser(id, newName, newEmail);
                        break;

                    case "4":
                        System.out.println("Введите id пользователя для удаления: ");
                        int idToDelete = Integer.parseInt(scanner.nextLine());
                        userService.deleteUser(idToDelete);
                        break;

                    case "5":
                        System.out.println("Выход из программы...");
                        break;

                    default:
                        System.out.println("Некорректный ввод. Повторите попытку.");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Ошибка при выполнении операции: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа.");
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
