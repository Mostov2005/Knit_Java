package org.knit.lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Task21 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filtered = filter(words, s -> s.startsWith("b"));
        System.out.println(filtered); // [banana]

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println(evenNumbers);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
