package com.github.rshtishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        init(list);// initilize list with 5 names
        print(list);// print all names in the list
        System.out.println();
        printEvenIndexNames(list);//print all names in that are in even index

    }

    private static void printEvenIndexNames(List<String> list) {
        for(int i =0;i<list.size();i++){
            if(i%2==0){
                System.out.println(String.format("Name: %s",list.get(i)));
            }
        }
    }

    private static void print(List<String> list) {
        for(String el:list){
            System.out.println(String.format("Name: %s",el));
        }
    }

    private static void init(List<String> list) {
        list.addAll(Arrays.asList("Jim", "Jane", "John", "Stuart", "Michael"));
    }
}
