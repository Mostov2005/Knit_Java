package org.knit.lab10;

public class Task19 {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(findMax(numbers)); // 5

        String[] words = {"apple", "banana", "cherry"};
        System.out.println(findMax(words)); // cherry

        String[] a = {};
        System.out.println(findMax(a)); // cherry
    }

    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array.length > 0) {
            T max = array[0];
            for (T element : array) {
                if (element.compareTo(max) > 0) {
                    max = element;
                }
            }
            return max;
        } else {
            System.out.println("Массив пустой!");
            return null;
        }
    }
}
