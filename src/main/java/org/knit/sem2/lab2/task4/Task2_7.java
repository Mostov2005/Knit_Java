package org.knit.sem2.lab2.task4;


public class Task2_7 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        // Поток производителя
        Thread producer = new Thread(() -> {
            while (true) {
                warehouse.produce();
                try {
                    Thread.sleep(1000); // Производитель добавляет товар каждую секунду
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Поток потребителя
        Thread consumer = new Thread(() -> {
            while (true) {
                warehouse.consume();
                try {
                    Thread.sleep(3000); // Потребитель забирает товар каждые 1.5 секунды
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

