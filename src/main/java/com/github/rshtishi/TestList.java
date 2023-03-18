package com.github.rshtishi;

import java.util.*;
import java.util.function.Predicate;


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
        Predicate<String> predicate1 = (s) -> s.length() <= 4;
        Predicate<String> predicate2 = (s) -> {
            return s.startsWith("M");
        };
        Predicate<String> predicate3 = predicate1.or(predicate2).negate();
        printNamesByPredicate(list, predicate1);
        printNamesByPredicate(list, predicate2);
        printNamesByPredicate(list, predicate3);


    }

    private static void printNamesByPredicate(List<String> list, Predicate<String> predicate) {
        for (String el : list) {
            if (predicate.test(el)) {
                System.out.println(el);
            }
        }
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
