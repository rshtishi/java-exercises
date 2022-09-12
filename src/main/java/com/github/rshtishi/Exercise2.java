package com.github.rshtishi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise2 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Jane", "Homer", "Judy","zeta");
        System.out.println(names);
        List<String> namesSorted = sortList(names);
        System.out.println(namesSorted);

    }

    private static List<String> sortList(List<String> list) {
         Collections.sort(list, (s1,s2)->{
             return s2.compareToIgnoreCase(s1);
         });
         return list;
    }
}
