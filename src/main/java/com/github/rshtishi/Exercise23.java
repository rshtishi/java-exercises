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

    static class Zoo {
        private Map<AnimalType, Integer> animals;

        public Zoo() {
            animals = new HashMap();
        }

        public void addAnimals(AnimalType type, int num) {
            if (this.animals.containsKey(type)) {
                int previousValue = this.animals.get(type);
                int value = previousValue + num;
                this.animals.put(type, value);
            } else {
                this.animals.put(type, num);
            }
        }

        public int getNumberOfAllAnimals(){
            return this.animals.entrySet()
                    .stream()
                    .map(e -> e.getValue())
                    .reduce(0,(a,b)->a+b);
        }

        public List<Map.Entry<AnimalType, Integer>> getAnimalsCountSorted(){
            List<Map.Entry<AnimalType,Integer>> list =this.animals.entrySet().stream().sorted(
                    (e1,e2)-> Integer.compare(e2.getValue(),e1.getValue())
            ).collect(Collectors.toList());
            return list;
        }
    }


    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimals(AnimalType.TIGER,5);
        zoo.addAnimals(AnimalType.LION,3);
        zoo.addAnimals(AnimalType.MONKEY,15);
        zoo.addAnimals(AnimalType.LION,2);
        zoo.addAnimals(AnimalType.SNAKE,20);

        System.out.println(zoo.animals);
        System.out.println(zoo.getNumberOfAllAnimals());
        System.out.println(zoo.getAnimalsCountSorted());

    }
}
