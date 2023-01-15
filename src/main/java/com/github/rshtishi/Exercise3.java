package com.github.rshtishi;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) {

        Map<String, String> addressMap = new LinkedHashMap<>();
        addressMap.put("Country", "Albania");
        addressMap.put("City", "Tirana");
        addressMap.put("Street", "Blv Gjergj Fishta");
        addressMap.put("Building", "15");
        System.out.println(addressMap);
        printMap(addressMap);

    }

    private static void printMap(Map<String, String> map) {
        List<String> stringList = map.entrySet().stream().map(el ->prepareText(el))
                .collect(Collectors.toList());
        String text = String.join(",\n",stringList)+".";
        System.out.println(text);
    }

    private static String prepareText(Map.Entry<String, String> el) {
        /**
         * Map.Entry      ->   String
         * Country=Albania -> Key:Country, Value:Albania
         * el ->
         * key -> el.getKey()
         * value -> el.getValue()
         */
        return "Text";
    }
}
