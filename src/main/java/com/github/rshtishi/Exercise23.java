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

        public int getAnimalNo() {
            return animalNo;
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
            int total = animals.stream()
                    .map(animal -> animal.getAnimalNo())
                    .reduce(0, (a, b) -> a + b);
            return total;
        }

        public Map<AnimalType, Integer> getAnimalsCount() {
            Map<AnimalType, Integer> map = animals.stream()
                    .collect(Collectors.toMap(animal -> animal.getType(), animal -> animal.getAnimalNo()));
            return map;
        }

        public List<Animal> getAnimalsCountSorted(){
            List<Animal> sortedAnimals = animals.stream()
                    .sorted((a1,a2)->Integer.compare(a2.getAnimalNo(),a1.getAnimalNo()))
                    .collect(Collectors.toList());
            return sortedAnimals;
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
        System.out.println(zoo.getNumberOfAllAnimals());
        System.out.println(zoo.getAnimalsCount());
        System.out.println(zoo.getAnimalsCountSorted());

    }
}
