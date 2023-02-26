package com.github.rshtishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise2Test {

    public static List<String> sortIgnoreCase(List<String> list){
        // TO DO
        // Sort list
        return list;
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
