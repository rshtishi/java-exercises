package com.github.rshtishi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise14 {

    public static void main(String[] args) {

        Random random = new Random();
        int[] array = random.ints(100, 0, 100).toArray();
        int count = 0;

        Map<Integer,Integer> valuesByFreqMap = generateValueByFreqMap(array);

        List<Integer> uniqueValues = generateUniqueValuesList(valuesByFreqMap);

        List<Integer> duplicates = generateDuplicatesValuesList(valuesByFreqMap);

        List<Integer> mostFrequentNumberList = generateMostFrequentNumberList(valuesByFreqMap)

    }

    private static List<Integer> generateMostFrequentNumberList(Map<Integer, Integer> valuesByFreqMap) {
        /**
         * convert map to entrySet
         * convert entrySet to stream
         * sort stream comparator
         * limit 25
         */
        return null;
    }

    private static List<Integer> generateDuplicatesValuesList(Map<Integer, Integer> valuesByFreqMap) {
        /**
         * TO DO
         *  convert map to entrySet
         *  convert entrySet to stream
         *  filter (entry) -> entry.getValue()>1
         *  map entry -> entry.getKey()
         *  convert stream to List
         */
        return null;
    }

    private static List<Integer> generateUniqueValuesList(Map<Integer, Integer> valuesByFreqMap) {
        /**
         * TO DO
         *  convert map to entrySet
         *  convert entrySet to stream
         *  filter (entry) -> entry.getValue()==1
         *  map entry -> entry.getKey()
         *  convert stream to List
         */
        return null;
    }

    private static Map<Integer, Integer> generateValueByFreqMap(int[] array) {
        /**
         * 1. If map contains key (number of array)
         * 1.a.1 (True) get value for key
         * 1.a.2 increment 1
         * 1.a.3 add to map
         * 1.b.1 (False) add to map key me value 1
         */
        return null;
    }
}
