package org.knit.sem2.lab2.task3;


public class Task2_6 {
    public static void main(String[] args) {
        RailwayCrossing crossing = new RailwayCrossing();

        // Поток поезда (каждые 10 секунд)
        Thread train = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                crossing.arriveTrain();
            }
        });

        // Потоки машин (едут постоянно)
        for (int i = 1; i <= 5; i++) {
            String carName = "Машина " + i;
            new Thread(() -> {
                while (true) {
                    crossing.passCar(carName);
                    try {
                        Thread.sleep(5000); // Интервал движения машин
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }

        train.start();
    }
}
