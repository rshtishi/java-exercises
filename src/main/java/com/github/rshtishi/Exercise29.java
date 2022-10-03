package com.github.rshtishi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise29 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Alan");
        list.add("James");
        list.add("Lisa");
        list.add("Jane");
        list.add("John");

        System.out.println(findPercentage(list, (String s) -> s.startsWith("Al")));

    }

    private static double findPercentage(List<String> list, Predicate<String> predicate) {
        long counter = list.stream().filter(predicate).count();
        return ((double) counter / list.size()) * 100;
    }
}
