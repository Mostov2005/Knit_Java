package org.knit.lab2;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        // Создаем файлы
        FileSystemComponent file1 = new File("file1.txt", 100);
        FileSystemComponent file2 = new File("file2.txt", 200);
        FileSystemComponent file3 = new File("file3.txt", 300);

        // Создаем папки
        FileSystemComponent folder1 = new Folder("Folder1");
        FileSystemComponent folder2 = new Folder("Folder2");

        // Добавляем файлы в папки
        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(folder1); // Вложенная папка

        // Выводим структуру файловой системы
        folder2.display("");

        // Выводим общий размер папки 2
        System.out.println("Total size of Folder2: " + folder2.getSize() + " bytes");
    }
}

abstract class FileSystemComponent {
    public abstract String getName();

    public abstract double getSize();

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Нельзя добавить компонент к файлу!");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Нельзя удалить компонент из файла!");
    }

    public void display(String indent) {
        System.out.println(indent + getName());
    }
}

class File extends FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public void display(String indent) {
        System.out.println(indent + getName() + " (" + getSize() + " bytes)");
    }
}

class Folder extends FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    public void display(String indent) {
        System.out.println(indent + getName());
        for (FileSystemComponent component : components) {
            component.display(indent + "\t");
        }
    }
}
