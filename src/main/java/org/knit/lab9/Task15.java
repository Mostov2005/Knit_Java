package org.knit.lab9;

public class Task15 {
    public static void main(String[] args) {
        for (Seasons season : Seasons.values()) {
            System.out.println(season + ": " + season.getTemperature() + ", типичный праздник - " + season.getHoliday());
        }

    }
}