package com.github.rshtishi;

import java.util.*;

public class Exercise6 {

    public static void main(String[] args) {

        Map<Integer, String> studentByGrade = new TreeMap<>();
        studentByGrade.put(10, "John");
        studentByGrade.put(5, "Jack");
        studentByGrade.put(7, "Rachel");
        studentByGrade.put(9, "Tera");


        printFirstAndLastEntrySet(studentByGrade);
    }

    private static void printFirstAndLastEntrySet(Map<Integer, String> map) {

        Object[] keys = map.keySet().toArray();
        if (keys.length > 0) {
            Integer firstKey = (Integer) keys[0];
            Integer lastKey = (Integer) keys[keys.length - 1];
            System.out.println("First Entry:" + firstKey + "->" + map.get(firstKey));
            System.out.println("Last Entry:" + lastKey + "->" + map.get(lastKey));
        }
    }
}
