package com.github.rshtishi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise24 {

    public static class BasketFullException extends Exception {
        public BasketFullException() {
            super("Basket full exception");
        }
    }

    public static class BasketEmptyException extends Exception {
        public BasketEmptyException() {
            super("Basket emptyException");
        }
    }

    public static class Basket<T> {

        private static final int SIZE = 10;

        private T[] array;
        private int index;

        public Basket() {
            array = (T[]) new Object[SIZE];
            index = 0;
        }

        public void addToBasket(T e) throws BasketFullException {
            if (index == SIZE - 1) {
                throw new BasketFullException();
            }
            array[index] = e;
            index++;
        }

        public void removeFromBasket() throws BasketEmptyException {
            if (index == 0) {
                throw new BasketEmptyException();
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

    public static void main(String[] args) throws BasketFullException, BasketEmptyException {
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
