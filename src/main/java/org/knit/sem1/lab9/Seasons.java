package org.knit.lab9;

enum Seasons {
    WINTER("Холодно", "Новый год"),
    SPRING("Тепло", "Пасха"),
    SUMMER("Жарко", "День Независимости"),
    AUTUMN("Дождливо", "Мой день рождения");

    private final String temperature;
    private final String holiday;

    Seasons(String temperature, String holiday) {
        this.temperature = temperature;
        this.holiday = holiday;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHoliday() {
        return holiday;
    }
}
