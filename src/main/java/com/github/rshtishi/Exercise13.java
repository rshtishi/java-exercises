package com.github.rshtishi;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise13 {

    static class CarService {

        private List<Exercise12.Car> carList;

        public CarService() {
            carList = new ArrayList<>();
        }

        public CarService(int size){
            carList = new ArrayList<>(size);
        }

        public void add(Exercise12.Car car) {
            this.carList.add(car);
        }

        public void remove(Exercise12.Car car) {
            this.carList.remove(car);
        }

        public List<Exercise12.Car> getCarList() {
            return this.carList;
        }

        public List<Exercise12.Car> getCarByEngine(Exercise12.EngineType engineType) {
            return carList.stream().filter(car -> car.getEngineType() == engineType)
                    .collect(Collectors.toList());
        }

        public List<Exercise12.Car> getCarsProducedBeforeYear(int year) {
            return carList.stream().filter(car -> car.getYearOfManufacture() < year).collect(Collectors.toList());
        }

        public Exercise12.Car getCheapestCar() {
            return carList.stream().min(Comparator.comparingDouble(car -> car.getPrice())).orElseThrow(NoSuchElementException::new);
        }

        public Exercise12.Car getMostExpensiveCar() {
            return carList.stream().max(Comparator.comparingDouble(Exercise12.Car::getPrice)).orElseThrow(()-> new NoSuchElementException());
        }

        public List<Exercise12.Car> getCarByTheNumberOfManufacture(int manufacturerNo) {
            return carList.stream().filter(car -> car.getManufacturerList() != null && car.getManufacturerList().size() >= 3).collect(Collectors.toList());
        }

        public List<Exercise12.Car> getCarsSorted(String order) {
            if (order.equalsIgnoreCase("ASC")) {
                Collections.sort(carList, (o1, o2) -> {
                    return o1.getYearOfManufacture() - o2.getYearOfManufacture();
                });
            }
            if (order.equalsIgnoreCase("DESC")) {
                Collections.sort(carList, (o1, o2) -> {
                    return o2.getYearOfManufacture() - o1.getYearOfManufacture();
                });
            }
            return carList;
        }

        public boolean isCarPresent(Exercise12.Car car) {
            return carList.contains(car);
        }

        public List<Exercise12.Car> findCarsProducedBy(Exercise12.Manufacturer manufacturer) {
            return carList.stream().filter(car -> car.getManufacturerList().contains(manufacturer))
                    .collect(Collectors.toList());
        }

        public List<Exercise12.Car> findCarProducedByManufacturesWithYearOfEstablishment(String operator, int year) {
            Predicate<Exercise12.Manufacturer> predicate;
            switch (operator) {
                case ">":
                    predicate = manufacturer -> manufacturer.getYearOfEstablishment() > year;
                    break;
                case "<":
                    predicate = manufacturer -> manufacturer.getYearOfEstablishment() < year;
                    break;
                case ">=":
                    predicate = manufacturer -> manufacturer.getYearOfEstablishment() >= year;
                    break;
                case "<=":
                    predicate = manufacturer -> manufacturer.getYearOfEstablishment() <= year;
                    break;
                case "==":
                    predicate = manufacturer -> manufacturer.getYearOfEstablishment() == year;
                    break;
                case "!=":
                    predicate = manufacturer -> manufacturer.getYearOfEstablishment() != year;
                default:
                    throw new IllegalArgumentException("Operator is illegal");
            }
            return carList.stream().filter(car-> hasManufacturer(car,predicate)).collect(Collectors.toList());
        }

        private boolean hasManufacturer(Exercise12.Car car, Predicate<Exercise12.Manufacturer> predicate) {
                return car.getManufacturerList().stream().anyMatch( manufacturer -> predicate.test(manufacturer));
        }


        public List<Exercise12.Car> getCarProducedByManufacturer(Exercise12.Manufacturer manufacturer) {
            return carList.stream().filter(car -> car.getManufacturerList().contains(manufacturer)).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        CarService carService = new CarService();
        Exercise12.Manufacturer fordManufacture = new Exercise12.Manufacturer("Ford", 1910, "USA");
        Exercise12.Manufacturer fiatManufacturer = new Exercise12.Manufacturer("Fiat", 1960, "Italy");
        Exercise12.Manufacturer toyotaManufacturer = new Exercise12.Manufacturer("Toyota", 1950, "Japan");
        Exercise12.Manufacturer VWManufacturer = new Exercise12.Manufacturer("volkwagen", 2011, "Germany");

        carService.add(new Exercise12.Car("Ford", "Fiesta", 35000, 2021, Arrays.asList(fordManufacture), Exercise12.EngineType.V6));
        carService.add(new Exercise12.Car("Ford", "Mustang", 65000, 2022, Arrays.asList(fordManufacture), Exercise12.EngineType.V12));
        carService.add(new Exercise12.Car("Ford", "Focus", 55000, 2021, Arrays.asList(fordManufacture), Exercise12.EngineType.V6));
        carService.add(new Exercise12.Car("Ford", "Escape", 25000, 2020, Arrays.asList(fordManufacture), Exercise12.EngineType.V8));
        carService.add(new Exercise12.Car("Fiat", "Punto", 2000, 2021, Arrays.asList(fiatManufacturer, toyotaManufacturer, fordManufacture), Exercise12.EngineType.S3));
        carService.add(new Exercise12.Car("Fiat", "Punto", 15000, 2019, Arrays.asList(fiatManufacturer, toyotaManufacturer, fordManufacture), Exercise12.EngineType.S3));
        carService.add(new Exercise12.Car("Fiat", "Punto", 5000, 2012, Arrays.asList(fiatManufacturer, toyotaManufacturer, fordManufacture), Exercise12.EngineType.S3));
        carService.add(new Exercise12.Car("Toyota", "Yaris", 25000, 2020, Arrays.asList(toyotaManufacturer), Exercise12.EngineType.S6));
        carService.add(new Exercise12.Car("Toyota", "Yaris", 15000, 2018, Arrays.asList(toyotaManufacturer), Exercise12.EngineType.S6));
        carService.add(new Exercise12.Car("Toyota", "Auris", 35000, 2020, Arrays.asList(toyotaManufacturer), Exercise12.EngineType.S6));
        carService.add(new Exercise12.Car("Toyota", "Auris", 25000, 2017, Arrays.asList(toyotaManufacturer), Exercise12.EngineType.S6));
        carService.add(new Exercise12.Car("VolkWagen", "Polo", 15000, 2020, Arrays.asList(VWManufacturer), Exercise12.EngineType.V6));
        carService.add(new Exercise12.Car("VolkWagen", "Polo", 3000, 2012, Arrays.asList(VWManufacturer), Exercise12.EngineType.V6));
        carService.add(new Exercise12.Car("VolkWagen", "Polo", 5000, 2016, Arrays.asList(VWManufacturer), Exercise12.EngineType.V6));
        carService.add(new Exercise12.Car("VolfWagen", "Golf", 25000, 2020, Arrays.asList(VWManufacturer), Exercise12.EngineType.V8));
        carService.add(new Exercise12.Car("VolfWagen", "Golf", 15000, 2018, Arrays.asList(VWManufacturer), Exercise12.EngineType.V8));

        System.out.println("Total No. of cars: " + carService.getCarList().size());
        Exercise12.Car car = new Exercise12.Car("Ford", "Fiesta", 35000, 2021, Arrays.asList(fordManufacture), Exercise12.EngineType.V6);



        carService.remove(car);
        System.out.println("Total No. of cars: " + carService.getCarList().size());

        System.out.println(carService.getCarByEngine(Exercise12.EngineType.V12));

        System.out.println();
        System.out.println(carService.getCarsProducedBeforeYear(2016));

        System.out.println(carService.getMostExpensiveCar());

        System.out.println(carService.getCarByTheNumberOfManufacture(3));
        System.out.println();

        carService.getCarsSorted("asc").stream().forEach(System.out::println);

        Exercise12.Car fiatPunto = new Exercise12.Car("Fiat", "Punto", 15000, 2019, Arrays.asList(fiatManufacturer, toyotaManufacturer, fordManufacture), Exercise12.EngineType.S3);

        System.out.println(carService.isCarPresent(fiatPunto));

        System.out.println();
        carService.findCarsProducedBy(toyotaManufacturer).stream().forEach(System.out::println);
        System.out.println();
        carService.findCarProducedByManufacturesWithYearOfEstablishment("==",1960).stream().forEach(System.out::println);
    }
}
