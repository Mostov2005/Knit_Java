package org.knit.lab11Kakovkin.task25;

import org.knit.lab11.task25.DatabaseConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileDAO {

    private static final String INSERT_FILE_SQL = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";

    public void saveFile(File file) throws SQLException, IOException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_FILE_SQL)) {

            statement.setString(1, file.getName());  // Имя файла

            // Чтение содержимого файла в бинарный формат
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                statement.setBytes(2, fileBytes);  // Содержимое файла в формате BYTEA
            }

            statement.executeUpdate();  // Выполняем запрос на добавление
        }
    }
}
