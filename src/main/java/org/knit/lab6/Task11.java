package org.knit.lab6;

import java.util.Scanner;
import java.util.TreeSet;


public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Показать всех студентов");
            System.out.println("4. Найти студента");
            System.out.println("5. Выйти");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя студента: ");
                    String nameToAdd = scanner.nextLine();
                    studentManager.addStudent(nameToAdd);
                    break;
                case 2:
                    System.out.print("Введите имя студента для удаления: ");
                    String nameToRemove = scanner.nextLine();
                    studentManager.removeStudent(nameToRemove);
                    break;
                case 3:
                    studentManager.showAllStudents();
                    break;
                case 4:
                    System.out.print("Введите имя студента для поиска: ");
                    String nameToFind = scanner.nextLine();
                    studentManager.findStudent(nameToFind);
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}

class StudentManager {
    private TreeSet<String> students = new TreeSet<>();

    public void addStudent(String studentName) {
        if (students.contains(studentName)) {
            System.out.println("Ошибка: Студент с таким именем уже существует.");
        } else {
            students.add(studentName);
            System.out.println("Студент добавлен.");
        }
    }

    public void removeStudent(String studentName) {
        if (students.remove(studentName)) {
            System.out.println("Студент удален.");
        } else {
            System.out.println("Ошибка: Студент не найден.");
        }
    }

    public void showAllStudents() {
        System.out.println("Список студентов:");
        if (students.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            students.forEach(System.out::println);
        }
    }

    public void findStudent(String studentName) {
        if (students.contains(studentName)) {
            System.out.println("Студент найден.");
        } else {
            System.out.println("Студент не найден.");
        }
    }
}
