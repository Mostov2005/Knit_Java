package org.knit.lab11.task25;

import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу или папке: ");
        String path = scanner.nextLine();

        FileProcessor processor = new FileProcessor();
        processor.processFiles(path);
    }
}

//CREATE TABLE files (
//        id SERIAL PRIMARY KEY,
//        file_name VARCHAR(255) NOT NULL,
//file_binary BYTEA NOT NULL
//);