package org.knit.lab9;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String input = scanner.nextLine().toUpperCase();

        TrafficLight currentLight = TrafficLight.valueOf(input);

        TrafficLight nextLight = currentLight.getNextLight();
        System.out.println("Следующий сигнал: " + nextLight);

    }
}

