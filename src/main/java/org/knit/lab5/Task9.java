package org.knit.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Task9 {

    //пример
    public static void main(String[] args) {
        List<String> words = getWords();

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int lenghtWorlds = words.size();

        //получает текущее время в миллисекундах
        long timeMillis = System.currentTimeMillis();
        long timeAfterMinute = timeMillis + 60000;

        int countWorld = 0;
        int countRightWorld = 0;
        int countSymbol = 0;

        while (System.currentTimeMillis() < timeAfterMinute) {
            int indexRandomWord = random.nextInt(lenghtWorlds);
            String randomWord = words.get(indexRandomWord);
            countWorld++;
            System.out.println("Введите слово: " + randomWord);
            String inputWord = scanner.next();

            System.out.println("Прошло " + ((System.currentTimeMillis() - timeMillis) / 1000) + " секунд.");
            countSymbol += inputWord.length();
            if ((randomWord.equalsIgnoreCase(inputWord)) && (System.currentTimeMillis() <= timeAfterMinute)) {
                countRightWorld++;
            }
        }

        System.out.println("Всего было слов: " + countWorld);
        System.out.println("Было введено верных слов во время: " + countRightWorld);
        System.out.println("Количество введенных символов: " + countSymbol);
        System.out.printf("Символов в секунду: %.5f", (double) countSymbol / 60);
    }


    //Возвращает список слов из файла
    public static List<String> getWords() {
        File file = new File("src/misc/dictionary.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            words.add(word);
        }
        scanner.close();
        return words;
    }
}