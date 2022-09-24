package com.github.rshtishi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise14 {

    public static void main(String[] args) {

        Random random = new Random();
        int[] array = random.ints(100000, 1, 100).toArray();
        int count = 0;

        //Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println();
        int[] uniqueArr = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toSet())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.stream(uniqueArr).forEach(e -> System.out.print(e + " "));

        System.out.println();
        System.out.println();

        Map<Integer, Integer> map = Arrays.stream(array).boxed().collect(Collectors.toMap(key->key, v -> 1, (a,b) ->a+b));
        System.out.println(map);

        System.out.println();
        System.out.println();

        map.entrySet().stream().sorted( (e1,e2)->e2.getValue().compareTo(e1.getValue())).forEach( e->System.out.print(e+" "));
    }
}
