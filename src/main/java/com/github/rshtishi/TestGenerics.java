package com.github.rshtishi;

import java.util.Comparator;
import java.util.function.*;

public class TestGenerics {


    public static class SupplierImpl implements Supplier<String> {

        @Override
        public String get() {
            return "Rando";
        }
    }

    public static void main(String[] args) {

        //1 Way
        Supplier<String> stringSuplier = new SupplierImpl();
        System.out.println(stringSuplier.get());

        //2 WAY
        Supplier<Double> doubleSupplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return 10.2;
            }
        };
        System.out.println(doubleSupplier.get());

        // 3 WAY
        Supplier<String> s1 = () -> "A";
        Supplier<String> s2 = () -> {
            return "A";
        };
        System.out.println(s1.get());
        System.out.println(s2.get());

        //Built in Functional interfaces

        //Return a random string
        Supplier<String> supplierEx = () -> "Supplier";
        System.out.println(supplierEx.get());

        //print string
        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("Hello World");

        //print string format, Country:Albania,Population:3000000
        BiConsumer<String, Integer> biConsumer = (String country, Integer population) -> System.out.println(String.format("Country:%s,Population:%d", country, population));
        biConsumer.accept("Albania ", 3000000);

        //check if string is empty
        Predicate<String> predicate = (String s) -> s.isEmpty();
        System.out.println(predicate.test("Rando"));

        //check if string is empty and integer is positive
        BiPredicate<String, Integer> biPredicate = (String s, Integer i)->s.isEmpty() && i>0;
        System.out.println(biPredicate.test("test", 10));

        //return the number of character of the string passsed as input
        Function<String, Integer> function = (String s)-> s.length();
        System.out.println(function.apply("Rando"));

        //return the string, Name: Rando, Age:30
        BiFunction<String, Integer, String> biFunction = (String s, Integer i)->String.format("Name: %s, Age:%d",s,i);
        System.out.println(biFunction.apply("Rando", 30));

        //increase number with 1
        UnaryOperator<Integer> unaryOperator = (Integer i)->i++;
        System.out.println(unaryOperator.apply(1));

        //add two number and return the results
        BinaryOperator<Integer> binaryOperator = (Integer a, Integer b)-> a+b;
        System.out.println(binaryOperator.apply(4, 2));

        //compare the strings
        Comparator<String> comparator = (String str1, String str2) -> str1.compareTo(str2);
        System.out.println(comparator.compare("John", "Jim"));


    }
}
