package org.knit.lab11Kakovkin.task24;


import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    // Этот интерфейс будет описывать методы для выполнения операций с пользователями в базе данных.

    void create(User user) throws SQLException;
    User findById(int id) throws SQLException;
    List<User> findAll() throws SQLException;
    void update(User user) throws SQLException;
    void delete(int id) throws SQLException;
    boolean emailExists(String email) throws SQLException;
}
