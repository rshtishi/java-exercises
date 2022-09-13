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

        printMap(addressMap);

    }

    private static void printMap(Map<String, String> map) {
        List<String> list = map.keySet().stream().map(key -> prepareText(key, map)).
                collect(Collectors.toList());
        String text = String.join(",\n", list) + ".";
        System.out.println(text);
    }

    private static String prepareText(String key, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder("Key:");
        stringBuilder.append(key).append(", Value:").append(map.get(key));
        return stringBuilder.toString();
    }
}
