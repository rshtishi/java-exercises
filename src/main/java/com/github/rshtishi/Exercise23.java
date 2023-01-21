package com.github.rshtishi;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise23 {

    static enum AnimalType {
        LION,
        TIGER,
        WOLF,
        HIPPO,
        ELEPHANT,
        MONKEY,
        SNAKE;
    }

    static class Animal {

        private AnimalType type;
        private int animalNo;

        public Animal(AnimalType type, int animalNo) {
            this.type = type;
            this.animalNo = animalNo;
        }

        public void incrementAnimalNo(int newAnimalsArrivedNo) {
            this.animalNo = this.animalNo + newAnimalsArrivedNo;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Animal) {
                Animal animal = (Animal) other;
                if (this.type == animal.getType()) {
                    return true;
                }
                return false;
            }

            return false;
        }

        @Override
        public String toString() {
            return String.format("{type:%s,animalNo:%d}", this.type, this.animalNo);
        }

        public AnimalType getType() {
            return type;
        }
    }

    static class Zoo {
        private Set<Animal> animals;

        public Zoo() {
            animals = new HashSet<>();
        }

        public void addAnimals(AnimalType type, int num) {
            Optional<Animal> possibleAnimal = animals.stream()
                    .filter(animal -> animal.getType() == type)
                    .findFirst();
            if (possibleAnimal.isPresent()) {
                Animal animal = possibleAnimal.get();
                animal.incrementAnimalNo(num);
            } else {
                animals.add(new Animal(type, num));
            }
        }

        public int getNumberOfAllAnimals() {
            return 0;
        }

        public List<Map.Entry<AnimalType, Integer>> getAnimalsCountSorted() {
            return null;
        }
    }


    public static void main(String[] args) {

        Zoo zoo = new Zoo();
        zoo.addAnimals(AnimalType.TIGER, 5);
        zoo.addAnimals(AnimalType.LION, 3);
        zoo.addAnimals(AnimalType.MONKEY, 15);
        zoo.addAnimals(AnimalType.LION, 2);
        zoo.addAnimals(AnimalType.SNAKE, 20);

        System.out.println(zoo.animals);
        //System.out.println(zoo.getNumberOfAllAnimals());
        //System.out.println(zoo.getAnimalsCountSorted());

    }
}
