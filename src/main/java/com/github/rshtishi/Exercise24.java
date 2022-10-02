package com.github.rshtishi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise24 {

    public static class Basket<T> {

        private static final int SIZE = 10;

        private T[] array;
        private int index;

        public Basket() {
            array = (T[]) new Object[SIZE];
            index = 0;
        }

        public void addToBasket(T e) {
            if (index == SIZE - 1) {
                throw new RuntimeException("Basket Full Exception");
            }
            array[index] = e;
            index++;
        }

        public void removeFromBasket() {
            if(index==0){
                throw new RuntimeException("Basket Empty Exception");
            }
            index--;
            array[index] = null;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            String elements = Arrays.stream(array).filter(e -> e != null).map(e -> e.toString()).collect(Collectors.joining(","));
            stringBuilder.append(elements);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Basket<String> basket = new Basket<>();
        basket.addToBasket("Test1");
        basket.addToBasket("Test2");
        basket.addToBasket("test3");
        System.out.println(basket);
        basket.removeFromBasket();
        System.out.println(basket);
        basket.removeFromBasket();
        System.out.println(basket);
        basket.removeFromBasket();
        System.out.println(basket);
        basket.removeFromBasket();
        System.out.println(basket);
    }
}
