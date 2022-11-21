package com.github.rshtishi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise14 {

    public static void main(String[] args) {

        Random random = new Random();
        int[] array = random.ints(100, 1, 100).toArray();
        int count = 0;

        Map<Integer, Integer> map = Arrays.stream(array) //instream
                .boxed() // Stream<Integer>
                .collect(Collectors.toMap(key -> key, v -> 1, (a, b) -> a + b));

        System.out.println(map);
        System.out.println();
        System.out.println();

        List<Integer> uniqueEl = map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println(uniqueEl);
        System.out.println();
        System.out.println();

        List<Integer> duplicates = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println(duplicates);
        System.out.println();
        System.out.println();

        List<Integer> sortedList = map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        sortedList.stream().limit(25).forEach(System.out::println);
    }
}
