package org.knit.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        File file = new File("src/misc/dictionary.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int countPolindrome = 0;
        System.out.println(scanner);
        DictionaryStatistic statistic = new DictionaryStatistic();
        String[] words = new String[scanner.];
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            if (isPalindrome(word)) {
                countPolindrome++;
            }
        }

        scanner.close();
    }

    public static boolean isPalindrome(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(s2);

    }
}

class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
    }
}

