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

        public CarService(int size) {
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

        public List<Exercise12.Car> getCarsWithV12Engine() {
            List<Exercise12.Car> v12Cars = carList.stream()
                    .filter(c -> c.getEngineType() == Exercise12.EngineType.V12)
                    .collect(Collectors.toList());
            return v12Cars;
        }

        public List<Exercise12.Car> getCarsFilteredByYearOfManufactuer(int yearOfManufactuer) {
            List<Exercise12.Car> carsBeforeYearX = carList.stream()
                    .filter(c -> c.getYearOfManufacture() <= yearOfManufactuer)
                    .collect(Collectors.toList());
            return carsBeforeYearX;
        }

        public Exercise12.Car getMostExpensiveCar() {
            Comparator<Exercise12.Car> sortByPriceAsc = (c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice());
            List<Exercise12.Car> sortedCarList = carList.stream()
                    .sorted(sortByPriceAsc.reversed())
                    .collect(Collectors.toList());
            //return sortedCarList.get(0);
            return carList.stream().max(sortByPriceAsc).get();
        }

        public Exercise12.Car getCheapestCar() {
            Comparator<Exercise12.Car> sortedByPriceAsc = (c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice());
            List<Exercise12.Car> sortedCarList = carList.stream()
                    .sorted(sortedByPriceAsc)
                    .collect(Collectors.toList());
            //return sortedCarList.get(0);
            return carList.stream().min(sortedByPriceAsc).get();
        }

        public Exercise12.Car getCarWithAtLeast3Producer() {
            Optional<Exercise12.Car> possibleCar = carList.stream()
                    .filter(car -> car.getManufacturerList().size() >= 3)
                    .findFirst();
            return possibleCar.get();
        }

        static enum SortingMode {
            ASC, DESC;
        }

        public List<Exercise12.Car> getSortedCarListByYearOfManufactured(SortingMode mode) {
            Comparator<Exercise12.Car> sortCarsComparator = (c1, c2) -> Integer.compare(c1.getYearOfManufacture(), c2.getYearOfManufacture());
            if (mode == SortingMode.DESC) {
                sortCarsComparator = sortCarsComparator.reversed();
            }
            //sortCarsComparator = sortCarsComparator.thenComparing((c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()));
            List<Exercise12.Car> sortedList = carList.stream()
                    .sorted(sortCarsComparator)
                    .collect(Collectors.toList());
            return sortedList;
        }

        public boolean isCarPresent(Exercise12.Car car){
            // TO DO
            return false;
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

        System.out.println("V12 car list");
        System.out.println(carService.getCarsWithV12Engine());

        System.out.println("Cars before year x");
        System.out.println(carService.getCarsFilteredByYearOfManufactuer(2012));

        System.out.println("Most Expensive Car");
        System.out.println(carService.getMostExpensiveCar());

        System.out.println("Cheapest Car");
        System.out.println(carService.getCheapestCar());

        System.out.println("Sorted By Year of Manufactured");
        System.out.println(carService.getSortedCarListByYearOfManufactured(CarService.SortingMode.ASC));

        Exercise12.Car fordCar =new Exercise12.Car("Ford", "Fiesta", 35000, 2021, Arrays.asList(fordManufacture), Exercise12.EngineType.V6);
        System.out.println("Does the car exist in the car list");
        System.out.println(carService.isCarPresent(fordCar));
    }
}
