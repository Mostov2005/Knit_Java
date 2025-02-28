package org.knit.lab11Kakovkin.task25;

import org.knit.lab11.task25.DatabaseConnection;
import org.knit.lab11Kakovkin.task25.FileDAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileProcessor {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB

    public void processFiles(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            // Если путь - это директория, обрабатываем все файлы в папке
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    processFile(f);
                }
            }
        } else if (file.isFile()) {
            processFile(file);
        } else {
            System.out.println("Указанный путь не существует.");
        }
    }

    private void processFile(File file) {
        if (file.length() < MAX_FILE_SIZE) {
            try {
                FileDAO fileDAO = new FileDAO();
                fileDAO.saveFile(file);
                System.out.println("Файл " + file.getName() + " успешно сохранен в базу данных.");
            } catch (SQLException | IOException e) {
                System.out.println("Ошибка при сохранении файла " + file.getName() + ": " + e.getMessage());
            }
        } else {
            System.out.println("Файл " + file.getName() + " слишком большой (больше 10 MB).");
        }
    }

    public void printAllFiles() throws SQLException {
        String selectSQL = "SELECT id, file_name FROM files";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Содержимое базы данных:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fileName = resultSet.getString("file_name");
                System.out.printf("ID: %d, File Name: %s%n", id, fileName);
            }
        }
    }
}
