package org.knit.lab10;


public class Task18 {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 30);

        System.out.println(pair.getFirst()); // Age
        System.out.println(pair.getSecond()); // 30

        pair.setSecond(35);
        System.out.println(pair.getSecond()); // 35

        pair.setFirst("aaaa");
        System.out.println(pair.getFirst());

    }
}


