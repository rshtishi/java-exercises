package com.github.rshtishi;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise13 {

    static class CarService {

        private List<Exercise12.Car> carList = new ArrayList<>();

        public CarService() {
            Exercise12.Manufacturer fordManufacture = new Exercise12.Manufacturer("Ford", 1910, "USA");
            Exercise12.Manufacturer fiatManufacturer = new Exercise12.Manufacturer("Fiat", 1960, "Italy");
            Exercise12.Manufacturer toyotaManufacturer = new Exercise12.Manufacturer("Toyota", 1950, "Japan");
            Exercise12.Manufacturer VWManufacturer = new Exercise12.Manufacturer("volkwagen", 2011, "Germany");
            carList.add(new Exercise12.Car("Ford", "Fiesta", 35000, 2021, Arrays.asList(fordManufacture), Exercise12.EngineType.V6));
            carList.add(new Exercise12.Car("Ford", "Mustang", 65000, 2022, Arrays.asList(fordManufacture), Exercise12.EngineType.V12));
            carList.add(new Exercise12.Car("Ford", "Focus", 55000, 2021, Arrays.asList(fordManufacture), Exercise12.EngineType.V6));
            carList.add(new Exercise12.Car("Ford", "Escape", 25000, 2020, Arrays.asList(fordManufacture), Exercise12.EngineType.V8));
            carList.add(new Exercise12.Car("Fiat", "Punto", 2000, 2021, Arrays.asList(fiatManufacturer, toyotaManufacturer, fordManufacture), Exercise12.EngineType.S3));
            carList.add(new Exercise12.Car("Fiat", "Punto", 15000, 2019, Arrays.asList(fiatManufacturer, toyotaManufacturer, fordManufacture), Exercise12.EngineType.S3));
            carList.add(new Exercise12.Car("Fiat", "Punto", 5000, 2012, Arrays.asList(fiatManufacturer, toyotaManufacturer, fordManufacture), Exercise12.EngineType.S3));
            carList.add(new Exercise12.Car("Toyota", "Yaris", 25000, 2020, Arrays.asList(toyotaManufacturer), Exercise12.EngineType.S6));
            carList.add(new Exercise12.Car("Toyota", "Yaris", 15000, 2018, Arrays.asList(toyotaManufacturer), Exercise12.EngineType.S6));
            carList.add(new Exercise12.Car("Toyota", "Auris", 35000, 2020, Arrays.asList(toyotaManufacturer), Exercise12.EngineType.S6));
            carList.add(new Exercise12.Car("Toyota", "Auris", 25000, 2017, Arrays.asList(toyotaManufacturer), Exercise12.EngineType.S6));
            carList.add(new Exercise12.Car("VolkWagen", "Polo", 15000, 2020, Arrays.asList(VWManufacturer), Exercise12.EngineType.V6));
            carList.add(new Exercise12.Car("VolkWagen", "Polo", 3000, 2012, Arrays.asList(VWManufacturer), Exercise12.EngineType.V6));
            carList.add(new Exercise12.Car("VolkWagen", "Polo", 5000, 2016, Arrays.asList(VWManufacturer), Exercise12.EngineType.V6));
            carList.add(new Exercise12.Car("VolfWagen", "Golf", 25000, 2020, Arrays.asList(VWManufacturer), Exercise12.EngineType.V8));
            carList.add(new Exercise12.Car("VolfWagen", "Golf", 15000, 2018, Arrays.asList(VWManufacturer), Exercise12.EngineType.V8));
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
            return carList.stream().min(Comparator.comparingDouble(Exercise12.Car::getPrice)).orElseThrow(NoSuchElementException::new);
        }

        public Exercise12.Car getMostExpensiveCar() {
            return carList.stream().max(Comparator.comparingDouble(Exercise12.Car::getPrice)).orElseThrow(NoSuchElementException::new);
        }

        public List<Exercise12.Car> getCarByTheNumberOfManufacture(int manufacturerNo) {
            return carList.stream().filter(car -> car.getManufacturerList() != null && car.getManufacturerList().size() >= 3).collect(Collectors.toList());
        }

        public List<Exercise12.Car> getCarsSorted(String order) {
            if (order.equals("ASC")) {
                Collections.sort(carList, (o1, o2) -> {
                    return o1.getYearOfManufacture() - o2.getYearOfManufacture();
                });
            }
            if (order.equals("DESC")) {
                Collections.sort(carList, (o1, o2) -> {
                    return o2.getYearOfManufacture() - o1.getYearOfManufacture();
                });
            }
            return carList;
        }

        public boolean isCarPresent(Exercise12.Car car) {
            return carList.stream().anyMatch(c -> c.equals(car));
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
            Optional<Exercise12.Manufacturer> possibleManufacture = carList.stream()
                    .flatMap(car -> car.getManufacturerList().stream()).filter(predicate).findFirst();
            if (possibleManufacture.isPresent()) {
                return carList.stream().filter(car -> car.getManufacturerList().contains(possibleManufacture.get()))
                        .collect(Collectors.toList());
            }
            return null;
        }


        public List<Exercise12.Car> getCarProducedByManufacturer(Exercise12.Manufacturer manufacturer) {
            return carList.stream().filter(car -> car.getManufacturerList().contains(manufacturer)).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        Exercise12.Manufacturer VWManufacturer = new Exercise12.Manufacturer("volkwagen", 2011, "Germany");
        CarService carService = new CarService();
        System.out.println("Total No. of cars: " + carService.getCarList().size());
        Exercise12.Car car = new Exercise12.Car("VolkWagen", "Tiguan", 35000, 2018, Arrays.asList(VWManufacturer), Exercise12.EngineType.V8);
        carService.add(car);
        System.out.println("After adding ww tiguan car, Total No. of cars: " + carService.getCarList().size());
        carService.remove(car);
        System.out.println("After remvoing ww tiguan car, Total No. of cars: " + carService.getCarList().size());
        List<Exercise12.Car> v8Cars = carService.getCarByEngine(Exercise12.EngineType.V8);
        System.out.println("Total No. of cars with V8 engine: " + v8Cars.size());
        List<Exercise12.Car> carProducedBefore2016 = carService.getCarsProducedBeforeYear(2016);
        System.out.println("Total No. of cars produced before 2016: " + carProducedBefore2016.size());
        Exercise12.Car cheapestCar = carService.getCheapestCar();
        System.out.println("Cheapest car: " + cheapestCar.getName() + "," + cheapestCar.getModel() + ", price: " + cheapestCar.getPrice());
        Exercise12.Car expensiveCar = carService.getMostExpensiveCar();
        System.out.println("Most expensive car: " + expensiveCar.getName() + " ," + expensiveCar.getModel() + " , price: " + expensiveCar.getPrice());
        List<Exercise12.Car> carManufacturedByMoreThan3 = carService.getCarByTheNumberOfManufacture(3);
        System.out.println("Total No. of cars produced by more than 3 manufactures: " + carManufacturedByMoreThan3.size());
        System.out.println("Is Tigual WW in the car list: " + carService.isCarPresent(car));
        List<Exercise12.Car> carManufactureByVW = carService.getCarProducedByManufacturer(VWManufacturer);
        System.out.println("Total No. of cars produced by VW manufactuer: "+carManufactureByVW.size());
        List<Exercise12.Car> carManufacturerByYearOfEstablishment = carService.findCarProducedByManufacturesWithYearOfEstablishment("==",2011);
        System.out.println("Total No. of cars produced by manufactuer with year of establishment 2011: "+carManufacturerByYearOfEstablishment.size());
    }
}
