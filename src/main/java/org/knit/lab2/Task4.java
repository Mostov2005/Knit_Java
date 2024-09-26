package org.knit.lab2;

public class Task4 {
    public static void main(String[] args) {
        Container container = new Container(1000);  // Создаем контейнер с объемом 1000

        Shape sphere = new Sphere(5);   // Создаем сферу с радиусом 5
        Shape cube = new Cube(3);       // Создаем куб со стороной 3

        container.add(sphere);  // Проверяем, можно ли добавить сферу
        container.add(cube);    // Проверяем, можно ли добавить куб
    }
}

class Container {
    private double remaining_size;

    public Container(double size) {
        this.remaining_size = size;
    }

    public void add(Shape shape) {
        double shape_size = shape.getVolume();

        if (shape_size <= remaining_size) {
            remaining_size -= shape_size;
            System.out.println("Фигура добавлена. Оставшийся объем: " + remaining_size);
        } else {
            System.out.println("Не хватает места для добавления фигуры.");
        }
    }
}


abstract class Shape {
    public abstract double getVolume();
}

class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

class Cube extends Shape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double getVolume() {
        return Math.pow(side, 3);
    }
}

class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * radius * radius * height;
    }
}