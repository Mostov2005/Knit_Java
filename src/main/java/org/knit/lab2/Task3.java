package org.knit.lab2;

//import org.knit.lab1.SimpleUrl;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            double first_number = 0;
            System.out.print("Введите первое число (Для выхода из программы введите \"exit\": ");
            String input = scanner.next();
            if (input.equals("exit")) {
                System.out.println("Завершение программы.");
                System.exit(0);
            } else {
                first_number = Double.parseDouble(input);
            }

            System.out.print("Введите оператор (+, -, *, /): ");
            String operator = scanner.next();

            System.out.print("Введите второе число: ");
            double second_number = scanner.nextDouble();
//            System.out.println(first_number);
//            System.out.println(operator);
//            System.out.println(second_number);

            Calculator Calc = new Calculator();

            switch (operator) {
                case "+":
                    Calc.add(first_number, second_number);
                    break;
                case "-":
                    Calc.subtract(first_number, second_number);
                    break;
                case "*":
                    Calc.multiply(first_number, second_number);
                    break;
                case "/":
                    if (second_number != 0) {
                        Calc.divide(first_number, second_number);
                    } else {
                        System.out.println("Деление на 0! Введите другое число.");
                    }
                    break;
                default:
                    System.out.println("Введён неизвестный оператор!");
            }
        }
    }
}

class Calculator {
    private double summ;
    private double subtract;
    private double multiply;
    private double divide;

    public void add(double a, double b) {
        summ = a + b;
        System.out.println(summ);
    }

    public void subtract(double a, double b) {
        subtract = a - b;
        System.out.println(subtract);
    }

    public void multiply(double a, double b) {
        multiply = a * b;
        System.out.println(multiply);
    }

    public void divide(double a, double b) {
        divide = a / b;
        System.out.println(divide);
    }
}