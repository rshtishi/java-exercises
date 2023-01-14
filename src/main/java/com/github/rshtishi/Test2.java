package com.github.rshtishi;

import java.util.*;

public class Test2 {

    static class Person implements Comparable<Person>{

        private String name;
        private int age;
        private double height;

        public Person(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }


        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Person)) {
                return false;
            }
            Person other = (Person) object;
            if (this.name.equals(other.getName()) &&
                    this.age == other.getAge() &&
                    this.height == other.getHeight()) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return String.format("{name:%s, age:%d, height: %f}", this.name, this.age, this.height);
        }

        @Override
        public int compareTo(Person o) {
            return name.compareTo(o.getName());
        }
    }

    public static void main(String[] args) {


        List<Person> personList = Arrays.asList(
                new Person("John", 30, 1.80),
                new Person("Jim", 20, 1.7),
                new Person("Jane", 23, 1.68)
        );
        System.out.println(personList);
        Collections.sort(personList);

        System.out.println("Natural Sort");
        System.out.println(personList);

        System.out.println("Reverse sorting by name");
        /**
         * TO DO
         * reverse sort by name
         */
        System.out.println(personList);

        System.out.println("Sort by age");
        /**
         * TO DO
         * sort by age
         */
        System.out.println(personList);


    }


}
