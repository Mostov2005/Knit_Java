package org.knit.lab8;

import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String FILE_NAME = "users.ser";

    public static void saveUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        }
    }

    public static List<User> loadUsers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
