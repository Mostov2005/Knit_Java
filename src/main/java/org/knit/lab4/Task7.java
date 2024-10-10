package org.knit.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;

public class Task7 {
    public static void main(String[] args) {

        File file = new File("src/misc/dictionary.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        StringBuilder allWords = new StringBuilder();
        int countPalindrome = 0;
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            allWords.append(word).append(" ");
            if (isPalindrome(word)) {
                countPalindrome++;
            }
        }
        scanner.close();

        String[] words = allWords.toString().split(" ");
        DictionaryStatistic statistic = new DictionaryStatistic(words, countPalindrome);

        statistic.calculateStatistics();
        System.out.println(statistic.toPrint());

        // Рандомное слово
        System.out.println(statistic.getRandomWord()); // полиметилметакрилат

        // Какие слова можно составить
        GameWords("кухня", words);

    }

    public static boolean isPalindrome(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(s2);
    }

    public static void GameWords(String word, String[] words) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toLowerCase().toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        System.out.println("Слова которые можно составить для " + word + ": ");
        for (String candidate : words) {
            if (candidate.length() <= word.length()) {
                Map<Character, Integer> candidateCount = new HashMap<>();
                for (char c : candidate.toCharArray()) {
                    candidateCount.put(c, candidateCount.getOrDefault(c, 0) + 1);
                }

                boolean canForm = true;
                for (Map.Entry<Character, Integer> entry : candidateCount.entrySet()) {
                    char letter = entry.getKey();
                    int requiredCount = entry.getValue();

                    if (charCount.getOrDefault(letter, 0) < requiredCount) {
                        canForm = false;
                        break;
                    }
                }
                if (canForm) {
                    System.out.println(candidate);
                }
            }
        }

    }
}


class DictionaryStatistic {
    Random random = new Random();
    private String[] words;
    private int dictionarySize;
    private int palindromeCount;
    private int maxWordLength;
    private int minWordLength;
    private char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    private Map<Character, Integer> frequency; // Map для хранения частоты букв

    public DictionaryStatistic(String[] words, int palindromeCount) {
        this.words = words;
        this.palindromeCount = palindromeCount;
        this.dictionarySize = words.length;
        this.frequency = new TreeMap<>(); // Инициализация пустого Map
        this.maxWordLength = 0;
        this.minWordLength = Integer.MAX_VALUE;
    }

    // Метод для вычисления статистик
    public void calculateStatistics() {
        for (String word : words) {
            int wordLength = word.length();

            if (wordLength > maxWordLength) maxWordLength = wordLength;
            if (wordLength < minWordLength) minWordLength = wordLength;

            for (char c : word.toLowerCase().toCharArray()) {
                if (Character.isLetter(c) && Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) { // без проверки не правильно работает
                    frequency.put(c, frequency.getOrDefault(c, 0) + 1);
                }
            }
        }
    }

    public String toPrint() {
        return "Всего слоа: " + dictionarySize + "\n" +
                "Слов \"палиндром\": " + palindromeCount + "\n" +
                "Маскимальная длина слова: " + maxWordLength + "\n" +
                "Минимальная длина слова: " + minWordLength + "\n" +
                "Частота букв: " + frequency;
    }

    public String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}
