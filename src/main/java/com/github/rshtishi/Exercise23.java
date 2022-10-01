package com.github.rshtishi;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise23 {

    public static enum AnimalType {
        LION,
        TIGER,
        WOLF,
        HIPPO,
        ELEPHANT,
        MONKEY,
        SNAKE;


    }

    public static class Animal {

        private String name;
        private AnimalType type;

        public Animal(String name, AnimalType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public AnimalType getType() {
            return type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Animal animal = (Animal) o;

            if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
            return type == animal.type;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Animal{");
            sb.append("name='").append(name).append('\'');
            sb.append(", type='").append(type).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Zoo {

        private List<Animal> animalList = new ArrayList<>();

        public Zoo() {
            animalList.add(new Animal("Leo", AnimalType.LION));
            animalList.add(new Animal("Silver", AnimalType.TIGER));
            animalList.add(new Animal("Leroy", AnimalType.LION));
            animalList.add(new Animal("Roy", AnimalType.TIGER));
            animalList.add(new Animal("Niko", AnimalType.WOLF));
            animalList.add(new Animal("Etien", AnimalType.SNAKE));
            animalList.add(new Animal("Babar", AnimalType.ELEPHANT));
            animalList.add(new Animal("Sohko", AnimalType.HIPPO));
            animalList.add(new Animal("Nero", AnimalType.HIPPO));
            animalList.add(new Animal("Sia", AnimalType.TIGER));
            animalList.add(new Animal("Alicia", AnimalType.MONKEY));
            animalList.add(new Animal("Bob", AnimalType.MONKEY));
            animalList.add(new Animal("Toro", AnimalType.SNAKE));
        }

        public int getNumberOfAllAnimals() {
            return animalList.size();
        }

        public Map<String, Long> getAnimalCount() {
            return animalList.stream().collect(Collectors.groupingBy(animal -> animal.getType().toString(),
                    Collectors.counting()));
        }

        public Map<String, Long> getAnimalCountSorted() {
            return animalList.stream().collect(Collectors.groupingBy(animal -> animal.getType().toString(), Collectors.counting()))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    }

    public static void main(String[] args) {

        Zoo zoo = new Zoo();
        System.out.println(zoo.getNumberOfAllAnimals());
        System.out.println(zoo.getAnimalCount());
        System.out.println(zoo.getAnimalCountSorted());

    }
}
