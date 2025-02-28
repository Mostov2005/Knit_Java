package org.knit.lab9;

enum Suit {
    SPADES("Пики"),
    HEARTS("Черви"),
    DIAMONDS("Бубны"),
    CLUBS("Трефы");

    private final String nameSuit;

    Suit(String nameSuit) {
        this.nameSuit = nameSuit;
    }

    @Override
    public String toString() {
        return nameSuit;
    }
}
