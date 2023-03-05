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
        Supplier<String> supplierEx = null;
        System.out.println(supplierEx.get());

        //print string
        Consumer<String> consumer = null;
        consumer.accept("Hello World");

        //print string format, Country:Albania,Population:3000000
        BiConsumer<String, Integer> biConsumer = null;
        biConsumer.accept("Albania ", 3000000);

        //check if string is empty
        Predicate<String> predicate = null;
        System.out.println(predicate.test("Rando"));

        //check if string is empty and integer is positive
        BiPredicate<String, Integer> biPredicate = null;
        System.out.println(biPredicate.test("test", 10));

        //return the character of the string passsed as input
        Function<String, Integer> function = null;
        System.out.println(function.apply("Rando"));

        //return the string, Name: Rando, Age:30
        BiFunction<String, Integer, String> biFunction = null;
        System.out.println(biFunction.apply("Rando", 30);

        //increase number with 1
        UnaryOperator<Integer> unaryOperator = null;
        System.out.println(unaryOperator.apply(1));

        //add two number and return the results
        BinaryOperator<Integer> binaryOperator = null;
        System.out.println(binaryOperator.apply(4, 2));

        //compare the strings
        Comparator<String> comparator = null;
        System.out.println(comparator.compare("John", "Jim"));


    }
}
