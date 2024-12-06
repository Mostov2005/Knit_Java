package org.knit.lab9;

import java.util.ArrayList;
import java.util.List;

public class Task16 {
    public static void main(String[] args) {
        List<String> deck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(rank + " " + suit);
            }
        }

        System.out.println("Колода: ");
        for (String card : deck) {
            System.out.println(card);
        }
    }
}

