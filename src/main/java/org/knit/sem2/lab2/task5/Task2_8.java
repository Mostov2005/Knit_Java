package org.knit.sem2.lab2.task5;

public class Task2_8 {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        // Поток светофора
        Thread light = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                trafficLight.switchLight();
            }
        });

        // Потоки машин
        for (int i = 1; i <= 5; i++) {
            String carName = "Машина " + i;
            new Thread(() -> {
                while (true) {
                    trafficLight.carArrive(carName);
                    try {
                        Thread.sleep(2000); // Интервал между появлениями машин на перекрестке
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }

        light.start();
    }
}
