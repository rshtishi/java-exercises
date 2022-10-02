package com.github.rshtishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise26 {

    public static enum CarType {
        COUPE, CABRIO, SEDAN, HATCHBACK
    }

    public static class Car {
        public String name;
        public String description;
        public CarType carType;

        public Car(String name, String description, CarType carType) {
            this.name = name;
            this.description = description;
            this.carType = carType;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public CarType getCarType() {
            return carType;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Car{");
            sb.append("name='").append(name).append('\'');
            sb.append(", description='").append(description).append('\'');
            sb.append(", carType=").append(carType);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Model {
        public String name;
        public int productionStartYear;
        List<Car> cars;

        public Model(String name, int productionStartYear, List<Car> cars) {
            this.name = name;
            this.productionStartYear = productionStartYear;
            this.cars = cars;
        }

        public String getName() {
            return name;
        }

        public int getProductionStartYear() {
            return productionStartYear;
        }

        public List<Car> getCars() {
            return cars;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Model{");
            sb.append("name='").append(name).append('\'');
            sb.append(", productionStartYear=").append(productionStartYear);
            sb.append(", cars=").append(cars);
            sb.append('}');
            return sb.toString();
        }
    }

    static class Manufacturer {
        public String name;
        public int yearOfCreation;
        List<Model> models;

        public Manufacturer(String name, int yearOfCreation, List<Model> models) {
            this.name = name;
            this.yearOfCreation = yearOfCreation;
            this.models = models;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYearOfCreation() {
            return yearOfCreation;
        }

        public void setYearOfCreation(int yearOfCreation) {
            this.yearOfCreation = yearOfCreation;
        }

        public List<Model> getModels() {
            return models;
        }

        public void setModels(List<Model> models) {
            this.models = models;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Manufacturer{");
            sb.append("name='").append(name).append('\'');
            sb.append(", yearOfCreation=").append(yearOfCreation);
            sb.append(", models=").append(models);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {

        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerList.add(new Manufacturer("Toyota", 1952,
                Arrays.asList(new Model("Yaris", 2007, Arrays.asList(new Car("Toyota yaris 1.4", "Economic", CarType.SEDAN), new Car("Toyota Yaris 1.6", "Sport", CarType.CABRIO))),
                        new Model("Auris", 2007, Arrays.asList(new Car("Toyota Auris 1.4", "Economic", CarType.SEDAN), new Car("Toyoto Auris 1.4", "Sport", CarType.CABRIO))))
        ));
        manufacturerList.add(new Manufacturer("VolkWagen", 1917, Arrays.asList(
                new Model("Golf", 2020, Arrays.asList(new Car("Golf 6", "Economic", CarType.SEDAN), new Car("Golf 6", "Sport", CarType.CABRIO), new Car("Golf 5", "Economic", CarType.SEDAN), new Car("Golf4", "Economic", CarType.SEDAN))))
        ));


        System.out.println("A------------------");
        manufacturerList.stream().flatMap(manufacturer -> manufacturer.getModels().stream()).forEach(System.out::println);
        System.out.println("B--------------------");
        manufacturerList.stream().flatMap(manufacturer -> manufacturer.getModels().stream()).flatMap(model -> model.getCars().stream()).forEach(System.out::println);
        System.out.println("C----------------------");
        manufacturerList.stream().map(manufacturer -> manufacturer.getName()).forEach(System.out::println);
        System.out.println("D---------------------");
        manufacturerList.stream().flatMap(manufacturer -> manufacturer.getModels().stream()).map(model -> model.getProductionStartYear()).distinct().forEach(System.out::println);
        System.out.println("E---------------------");
        manufacturerList.stream().flatMap(manufacturer -> manufacturer.getModels().stream()).flatMap(model -> model.getCars().stream()).map(car -> car.getName()).distinct().forEach(System.out::println);
        System.out.println("F---------------------");
        manufacturerList.stream().flatMap(manufacturer -> manufacturer.getModels().stream()).flatMap(model -> model.getCars().stream()).map(car -> car.getDescription()).forEach(System.out::println);
        System.out.println("G---------------------");
        manufacturerList.stream().flatMap(manufacturer -> manufacturer.getModels().stream()).filter(model -> model.getProductionStartYear() % 2 == 0).forEach(System.out::println);
        System.out.println("H---------------------");
        manufacturerList.stream().filter(manufacturer -> manufacturer.getYearOfCreation() % 2 == 0).flatMap(manufacturer -> manufacturer.getModels().stream()).flatMap(model -> model.getCars().stream()).forEach(System.out::println);
        System.out.println("I----------------------");
        manufacturerList.stream().filter(manufacturer -> manufacturer.getYearOfCreation() % 2 == 1).flatMap(manufacturer -> manufacturer.getModels().stream()).filter(model -> model.getProductionStartYear() % 2 == 0).flatMap(model -> model.getCars().stream()).forEach(System.out::println);
        System.out.println("K----------------------");
        manufacturerList.stream().filter(manufacturer -> manufacturer.getYearOfCreation() % 2 == 0).flatMap(manufacturer -> manufacturer.getModels().stream()).filter(model -> model.getProductionStartYear() % 2 == 1).flatMap(model -> model.getCars().stream()).filter(car -> car.getCarType() == CarType.CABRIO).forEach(System.out::println);
        System.out.println("L----------------------");
        manufacturerList.stream().filter(manufacturer -> manufacturer.getYearOfCreation() < 1919).flatMap(manufacturer -> manufacturer.getModels().stream()).filter(model -> model.getProductionStartYear() > 2019).flatMap(model -> model.getCars().stream()).filter(car -> car.getCarType() == CarType.SEDAN).forEach(System.out::println);

    }

}
