package com.github.rshtishi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise4 {

    static class Storage {

        private Map<String, List<String>> data;

        public Storage() {
            data = new HashMap<>();
        }

        public void addToStorage(String key, String value) {
            /**
             * 1. Check if key Exists in map
             * 1.a.1 if exists then get List corresponding to the key
             * 1.a.2 add value to the List
             * 1.b.1 if doesnt exist create a new list
             * 1.b.2 add value to the list
             * 1.b.3 and key and list in map
             */
            if (data.containsKey(key)) {
                List<String> values = data.get(key);
                values.add(value);
            } else {
                List<String> values = new ArrayList<>();
                values.add(value);
                data.put(key, values);
            }
        }

        public void printValues(String key) {
            /**
             * 1. convert map to entryset
             * 2. convert entryset to stream
             * 3. filter el , el.getKey()===key
             * 3. flatmap {java ->[John,Jim,Jane]} -> John, Jim, Jane
             * 4. foreach print
             */
            List<String> valueList = data //{java=[John, Gerard, Jane, Mary], javascript=[John, Jane]}
                    .entrySet(). //[java=[John, Gerard, Jane, Mary], javascript=[John, Jane] ]
                            stream() //java=[John, Gerard, Jane, Mary]
                    .filter(el -> el.getKey().equals(key)) // filter by key
                    .flatMap(el -> el.getValue().stream())
                    .collect(Collectors.toList());
            String text = String.join(",\n", valueList);
            System.out.println(text);
        }

        public void findValues(String value) {
            /**
             * 1. convert map -> entryset
             * 2. convert entrySet -> stream
             * 3. filter by value java ->[John,Jim,Jane]} -> el.getValue().contains(value)
             * 4. map entry to string , e.g. {java ->[John,Jim,Jane]} -> java
             * 5. foreach print
             */
            List<String> keyList = data //{java=[John, Gerard, Jane, Mary], javascript=[John, Jane]}
                    .entrySet() //[java=[John, Gerard, Jane, Mary], javascript=[John, Jane] ]
                    .stream() //java=[John, Gerard, Jane, Mary]
                    .filter(el -> el.getValue().contains(value)) // filter by value (trainer name)
                    .map(el -> el.getKey())
                    .collect(Collectors.toList());
            String text = String.join(",\n",keyList);
            System.out.println(text);
        }
    }

    public static void main(String[] args) {

        Storage storage = new Storage();
        storage.addToStorage("java", "John");
        storage.addToStorage("java", "Gerard");
        storage.addToStorage("java", "Jane");
        storage.addToStorage("java", "Mary");
        storage.addToStorage("javascript", "John");
        storage.addToStorage("javascript", "Jane");

        System.out.println(storage.data);
        storage.printValues("javascript");

        storage.findValues("John");
    }
}

