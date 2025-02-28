package org.knit.lab11Kakovkin.task24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    // Этот класс будет реализовывать логику, проверять уникальность email и взаимодействовать с UserDAO.

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) throws SQLException {
        if (name == null || name.isEmpty()) {
            System.out.println("Имя не должно быть пустым.");
        } else if (email == null || email.isEmpty()) {
            System.out.println("Email не должен быть пуст.");
        } else if (userDAO.emailExists(email)) {
            System.out.println("Email уже существует!");
        } else {
            userDAO.create(new User(name, email));
            System.out.println("Юзер добавлен успешно.");
        }
    }

    public List<User> listAllUsers() throws SQLException {
        List<User> users = userDAO.findAll();

        return users;
    }

    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) != null) {
            userDAO.delete(id);
            System.out.println("Юзер успешно удалён.");
        } else {
            System.out.println("Юзер не найден.");
        }
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User user = userDAO.findById(id);
        if (user != null) {
            user.setName(newName);
            user.setEmail(newEmail);
            userDAO.update(user);
            System.out.println("Юзер успешно обновлён.");
        } else {
            System.out.println("Юзер не найден.");
        }
    }
}
