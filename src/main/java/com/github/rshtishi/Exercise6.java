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

        Object[] entryArray = map.entrySet().toArray();
        if (entryArray.length > 0) {
            System.out.println(entryArray[0]);
            System.out.println(entryArray[entryArray.length - 1]);
        }
    }
}
