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

    }

    private static String prepareText(String key, Map<String, String> map) {
        return null;
    }
}
