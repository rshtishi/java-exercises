package com.github.rshtishi;

import java.util.ArrayList;
import java.util.List;


public class TestList {

    public static void main(String[] args){

        List<String>  list = new ArrayList<>();
        init(list);// initilize list with 5 names
        print(list);// print all names in the list
        printEvenIndexNames(list);//print all names in that are in even index

    }

    private static void printEvenIndexNames(List<String> list) {
        //TO DO
        //print even index names
        //use String.format
    }

    private static void print(List<String> list) {
        // TO DO
        //print all names in format Name: X
        //use String.format
    }

    private static void init(List<String> list) {
        //TO DO
        //initilize list with 5 names
    }
}
