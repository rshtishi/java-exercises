package com.github.rshtishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1Test {

    public static void sort(List<String> stringList){

        List<String> sortedList = stringList.stream().sorted().collect(Collectors.toList());
        stringList.clear();
        stringList.addAll(sortedList);
    }


    public static void main(String[] args){
        List<String> input = new ArrayList<>(Arrays.asList("John","Jane","Jim"));
        System.out.println("Unsorted list");
        System.out.println(input);
        System.out.println("Sorted Asc list");
        sort(input);
        System.out.println(input);


    }


}
