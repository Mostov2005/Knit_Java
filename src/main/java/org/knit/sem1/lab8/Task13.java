package org.knit.sem1.lab8;


import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("Ваня", 18, "abcd@gmail.com");

//        while (true) {
//            System.out.println("Меню:");
//            System.out.println("1. Добавить студента");
//            System.out.println("2. Удалить студента");
//            System.out.println("3. Показать всех студентов");
//            System.out.println("4. Найти студента");
//            System.out.println("5. Выйти");
//            System.out.print("Выберите опцию: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();

//            switch (choice) {
//                case 1:
//                    System.out.print("Введите имя студента: ");
//                    String nameToAdd = scanner.nextLine();
//                    studentManager.addStudent(nameToAdd);
//                    break;
//                case 2:
//                    System.out.print("Введите имя студента для удаления: ");
//                    String nameToRemove = scanner.nextLine();
//                    studentManager.removeStudent(nameToRemove);
//                    break;
//                case 3:
//                    studentManager.showAllStudents();
//                    break;
//                case 4:
//                    System.out.print("Введите имя студента для поиска: ");
//                    String nameToFind = scanner.nextLine();
//                    studentManager.findStudent(nameToFind);
//                    break;
//                case 5:
//                    System.out.println("Выход из программы...");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
//            }
    }
}

