package com.github.rshtishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2Test {

    public static List<String> sortIgnoreCase(List<String> list){
        Comparator<String> sortAscIgnoreCase = (s1,s2) -> s1.compareToIgnoreCase(s2) ;
        Comparator<String> sortDescIgnoreCase = sortAscIgnoreCase.reversed();

        return list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        }).collect(Collectors.toList());
    }

    public static void main(String[] args){
        List<String> input = new ArrayList<>(Arrays.asList("jake","John","jane","Jim"));
        System.out.println("Unsorted list");
        System.out.println(input);
        //expected: John,Jim,jane,jake
        System.out.println("Sorted Asc list");
        System.out.println(sortIgnoreCase(input));
    }
}
