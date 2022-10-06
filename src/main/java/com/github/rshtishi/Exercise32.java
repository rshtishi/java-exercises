package com.github.rshtishi;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise32 {

    public static class Person implements Serializable {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Person> list = Arrays.asList(new Person("Sherlock Holmes", 45), new Person("Watson", 55));
        String fileStr = "src/main/resources/object_db";
        File file = new File(fileStr);
        saveList(list, file);
        List<Person> retrivedFromFileList = retrieveList(file);
        System.out.println(retrivedFromFileList);
    }

    private static List<Person> retrieveList(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
        List<Person> personList = new ArrayList<>();
        Person person = null;
        while (true) {
            try {
                person = (Person) stream.readObject();
                if (person != null) {
                    personList.add(person);
                }
            } catch (EOFException exc) {
                break;
            }
        }
        stream.close();
        return personList;
    }

    private static void saveList(List<Person> list, File file) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
        for (Person person : list) {
            stream.writeObject(person);
        }
        stream.close();
    }
}
