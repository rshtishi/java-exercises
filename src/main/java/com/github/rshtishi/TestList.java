package com.github.rshtishi;

import java.util.*;


public class TestList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        init(list);
        print(list);
        System.out.println();
        printEvenIndexNames(list);

        System.out.println();
        init(list);
        print(list);
        System.out.println();
        printAllNames(list);
        printFrequencyByName(list); //implement method

        System.out.println();
        printNamesThatHaveLessThanFourCharacters(list); //implement method

    }

    private static void printNamesThatHaveLessThanFourCharacters(List<String> list) {
        // TO DO
        //print all names that size does not exceed 4 characters
    }

    private static void printFrequencyByName(List<String> list) {
        // TO DO
        Map<String, Integer> freqByName = new HashMap<>();
        for (String el : list) {
            if (freqByName.containsKey(el)) {
                int curVal = freqByName.get(el);
                curVal++;
                freqByName.put(el, curVal);
            } else {
                freqByName.put(el, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : freqByName.entrySet()) {
            System.out.println(String.format("Name: %s, Frequency: %d", entry.getKey(), entry.getValue()));
        }

    }

    private static void printAllNames(List<String> list) {
        Set<String> set = new HashSet<>();
        set.addAll(list);
        print(set);
    }

    private static void printEvenIndexNames(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(String.format("Name: %s", list.get(i)));
            }
        }
    }

    private static void print(Collection<String> list) {
        for (String el : list) {
            System.out.println(String.format("Name: %s", el));
        }
    }

    private static void init(List<String> list) {
        list.addAll(Arrays.asList("Jim", "Jane", "John", "Stuart", "Michael"));
    }
}
