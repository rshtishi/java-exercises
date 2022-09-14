package com.github.rshtishi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise4 {

    static class Storage {

        private Map<String, List<String>> data;

        public Storage() {
            data = new HashMap<>();
        }

        public void addToStorage(String key, String value) {
            List<String> values = data.get(key);
            if (values == null) {
                values = new ArrayList<>();
            }
            values.add(value);
            data.put(key,values);
        }

        public void printValues(String key) {
            data.get(key).stream()
                    .forEach(System.out::println);
        }

        public void findValues(String value) {
            data.entrySet().stream().filter(entry -> entry.getValue().contains(value))
                    .map(entry -> entry.getKey())
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {

        Storage storage = new Storage();
        storage.addToStorage("java","John");
        storage.addToStorage("java","Gerard");
        storage.addToStorage("java","Jane");
        storage.addToStorage("java","Mary");
        storage.addToStorage("javascript","John");
        storage.addToStorage("javascript","Jane");

        storage.printValues("javascript");

        storage.findValues("John");
    }
}
