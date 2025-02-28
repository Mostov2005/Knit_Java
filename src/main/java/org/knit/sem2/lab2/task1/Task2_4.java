package org.knit.sem2.lab2.task1;

public class Task2_4 {
    public static void main(String[] args) {
        GasStation station = new GasStation(2);

        for (int i = 1; i <= 7; i++) {
            String carName = "Машина " + i;
            new Thread(() -> station.refuel(carName)).start();
        }
    }
}



