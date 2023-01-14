package com.github.rshtishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

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

        public List<Exercise12.Car> getV12EngineCars() {
            List<Exercise12.Car> v12List = new ArrayList<>();
            for (Exercise12.Car car : this.carList) {
                if (car.getEngineType() == Exercise12.EngineType.V12) {
                    v12List.add(car);
                }
            }
            return v12List;
        }

        public List<Exercise12.Car> getV12EngineCarsX() {
            return this.carList.stream().filter(car -> car.getEngineType() == Exercise12.EngineType.V12)
                    .collect(Collectors.toList());
        }

        public List<Exercise12.Car> getCarsProducedBefore(int year) {
            return this.carList.stream().filter(car -> car.getYearOfManufacture() < year)
                    .collect(Collectors.toList());
        }

        public Exercise12.Car getCheapestCar() {

            return this.carList.stream().max(
                    (c1,c2) ->  {
                        return Double.compare(c1.getPrice(),c2.getPrice());
                    }

            ).get();
        }

        public List<Exercise12.Car> getCarsWithMoreThan3Manufacturer(){
            return this.carList.stream().filter(
                    car ->  car.getManufacturerList()!=null && car.getManufacturerList().size()>=3
                    )
                    .collect(Collectors.toList());
        }

        public List<Exercise12.Car> getSortedList(String orderBy){
            Comparator<Exercise12.Car> comparator;
            if(orderBy.equalsIgnoreCase("ASC")){
                comparator = (c1,c2) -> {
                    return Integer.compare(c1.getYearOfManufacture(),c2.getYearOfManufacture());

                };
            } else if(orderBy.equalsIgnoreCase("DESC")){
                comparator = (c1,c2) -> {
                    return Integer.compare(c2.getYearOfManufacture(),c1.getYearOfManufacture());

                };
            } else {
                throw new IllegalArgumentException("Unknow order by");
            }
            return this.carList.stream().sorted(comparator).collect(Collectors.toList());
        }

        public List<Exercise12.Car> getcarListByManufacture(Exercise12.Manufacturer manufacturer){
            return this.carList.stream().filter( car -> car.getManufacturerList().contains(manufacturer))
                    .collect(Collectors.toList());
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

        //System.out.println(carService.getV12EngineCars());
        //System.out.println(carService.getV12EngineCarsX());
        //System.out.println(carService.getCarsProducedBefore(2016));
        //System.out.println(carService.getCheapestCar());
        //System.out.println(carService.getCarsWithMoreThan3Manufacturer());
        //System.out.println(carService.getSortedList("DESC"));
        System.out.println(carService.getcarListByManufacture(toyotaManufacturer));

    }
}
