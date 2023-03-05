package com.github.rshtishi;

import java.util.function.Supplier;

public class TestGenerics {


    public static class SupplierImpl implements Supplier<String>{

        @Override
        public String get() {
            return "Rando";
        }
    }

    public static void main(String[] args){

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
        Supplier<String> s2 = () -> { return "A";};
        System.out.println(s1.get());
        System.out.println(s2.get());

    }
}
