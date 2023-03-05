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

        Supplier<String> stringSuplier = new SupplierImpl();
        System.out.println(stringSuplier.get());
    }
}
