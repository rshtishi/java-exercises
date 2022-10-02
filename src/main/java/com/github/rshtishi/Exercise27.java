package com.github.rshtishi;

public class Exercise27 {

    public static class Joiner<T> {

        private String delimeter;

        public Joiner(String delimeter) {
            this.delimeter = delimeter;
        }

        public String join(T... t) {
            StringBuilder stringBuilder = new StringBuilder();
            for (T el : t) {
                stringBuilder.append(el).append(delimeter);
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(delimeter));
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {

        Joiner<String> joiner = new Joiner<>(",");
        String result = joiner.join("Java", "C#", "JavaScript");

        System.out.println(result);
    }
}
