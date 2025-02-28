package org.knit.sem2.lab2.task2;

public class Task2_5 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // Поток повара (готовит блюда)
        Thread chef = new Thread(() -> {
            while (true) {
                restaurant.cook();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Поток официанта (раздает блюда)
        Thread waiter = new Thread(() -> {
            while (true) {
                restaurant.serve();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        chef.start();
        waiter.start();
    }
}
