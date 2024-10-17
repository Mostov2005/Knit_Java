package org.knit.lab5;

import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пенал"};
        Random random = new Random();
        ShopItem[] items = new ShopItem[100];

        // Генерация 100 объектов ShopItem
        for (int i = 0; i < items.length; i++) {
            String name = names[random.nextInt(names.length)];
            int price = 10 + random.nextInt(90); // цена
            int quantity = random.nextInt(20) + 1; // количество
            items[i] = new ShopItem(name, price, quantity);
        }

        // Сортировка массива по цене
        Arrays.sort(items, Comparator.comparingDouble(ShopItem::getPrice));

        // Вывод объектов
        for (ShopItem item : items) {
            System.out.println(item);
        }

        // Подсчет количества одинаковых ShopItem
        Map<ShopItem, Integer> itemCount = new HashMap<>();
        for (ShopItem item : items) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        System.out.println("\nКоличество одинаковых ShopItem:");
        itemCount.forEach((item, count) -> {
            if (count > 1) {
                System.out.println(item + " - " + count + " шт.");
            }
        });
    }
}

class ShopItem {
    private String name;
    private int price;
    private int quantity;

    public ShopItem(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "name: " + name + "; price: " + price + "; quantity: " + quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ShopItem shopItem = (ShopItem) obj;
        return Integer.compare(shopItem.price, price) == 0 && quantity == shopItem.getQuantity() && name.equals(shopItem.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}


