package org.knit.lab10;

import java.util.ArrayList;
import java.util.List;

public class Task22 {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);

        System.out.println(dictionary.get("Alice")); // 25
        System.out.println(dictionary.get("key")); // null

        dictionary.remove("Alice");
        System.out.println(dictionary.get("Alice")); // null
    }
}

class Dictionary<K, V> {
    private List<Tuple<K, V>> dictionary;

    public Dictionary() {
        dictionary = new ArrayList<>();
    }

    public void put(K key, V value) {
        for (Tuple<K, V> tuple : dictionary) {
            if (tuple.getKey().equals(key)) {
                tuple.setValue(value);
                return;
            }
        }
        dictionary.add(new Tuple<>(key, value));
    }

    public V get(K key) {
        for (Tuple<K, V> tuple : dictionary) {
            if (tuple.getKey().equals(key)) {
                return tuple.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        for (Tuple<K, V> tuple : dictionary) {
            if (tuple.getKey().equals(key)) {
                dictionary.remove(tuple);
            }
        }
    }
}

class Tuple<K, V> {
    private K key;
    private V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

