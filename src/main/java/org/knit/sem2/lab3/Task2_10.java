package org.knit.sem2.lab3;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2_10 {
    public static void main(String[] args) {
        while (true) {
            startRace();
            try {
                Thread.sleep(10000); // Ждём 10 секунд перед следующей гонкой
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void startRace() {
        int runners = 5;
        System.out.println("Гонка скоро начнётся, Спортсмены, подойти к старту!");
        CyclicBarrier startBarrier = new CyclicBarrier(runners, () -> {
            System.out.println("Гонка началась!");
        });

        CyclicBarrier finishBarrier = new CyclicBarrier(runners, () -> {
            System.out.println("Гонка Завершилась!");
        });
        ExecutorService executorService = Executors.newFixedThreadPool(runners);

        for (int i = 1; i <= runners; i++) {
            executorService.submit(new Runner(i, startBarrier, finishBarrier));
        }

        executorService.shutdown();
    }
}
