package org.knit.lab10;

public class Task23 {
    public static void main(String[] args) {
        printType(123);
        printType("Hello");
        printType(2.4);
        printType(new Integer[]{1, 2, 3});
    }

    public static <T> void printType(T object) {
        System.out.println(object.getClass().getName());
    }
}
