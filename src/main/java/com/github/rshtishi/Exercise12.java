package com.github.rshtishi;

import java.util.Arrays;
import java.util.List;

public class Exercise12 {

    static class Manufacturer {
        private String name;
        private int yearOfEstablishment;
        private String country;

        Manufacturer(String name, int yearOfEstablishment, String country) {
            this.name = name;
            this.yearOfEstablishment = yearOfEstablishment;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYearOfEstablishment() {
            return yearOfEstablishment;
        }

        public void setYearOfEstablishment(int yearOfEstablishment) {
            this.yearOfEstablishment = yearOfEstablishment;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public int hashCode() {
            int hashCode = 1 + 31 * yearOfEstablishment;
            if (name != null) {
                hashCode += 31 * name.hashCode();
            }
            if (country != null) {
                hashCode += 31 * country.hashCode();
            }
            return hashCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Manufacturer)) {
                return false;
            }
            Manufacturer other = (Manufacturer) o;
            boolean nameEquals = (this.name == null && other.getName() == null) || (this.name != null && this.name.equals(other.getName()));
            boolean countryEquals = (this.country == null && other.getCountry() == null) || (this.country != null && this.country.equals(other.getCountry()));
            return this.yearOfEstablishment == other.getYearOfEstablishment() && nameEquals && countryEquals;
        }

        @Override
        public String toString(){
            return String.format("Manufacturer(name=%s, yearOfEstablishment=%d, country=%s)",name,yearOfEstablishment,country);
        }
    }

    static enum EngineType {
        V12, V8, V6, S6, S4, S3;
    }

    static class Car {
        private String name;
        private String model;
        private double price;
        private int yearOfManufacture;
        private List<Manufacturer> manufacturerList;
        private EngineType engineType;

        Car(String name, String model, double price, int yearOfManufacture, List<Manufacturer> manufacturerList, EngineType engineType) {
            this.name = name;
            this.model = model;
            this.price = price;
            this.yearOfManufacture = yearOfManufacture;
            this.manufacturerList = manufacturerList;
            this.engineType = engineType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getYearOfManufacture() {
            return yearOfManufacture;
        }

        public void setYearOfManufacture(int yearOfManufacture) {
            this.yearOfManufacture = yearOfManufacture;
        }

        public List<Manufacturer> getManufacturerList() {
            return manufacturerList;
        }

        public void setManufacturerList(List<Manufacturer> manufacturerList) {
            this.manufacturerList = manufacturerList;
        }

        public EngineType getEngineType() {
            return engineType;
        }

        public void setEngineType(EngineType engineType) {
            this.engineType = engineType;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
            result = 31 * result + (this.model == null ? 0 : this.model.hashCode());
            result = 31 * result + (int) this.price;
            result = 31 * result + this.yearOfManufacture;
            for (Manufacturer manufacturer : this.manufacturerList) {
                result = 31 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
            }
            result = 31 * result + (this.engineType == null ? 0 : engineType.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Car)) {
                return false;
            }
            Car other = (Car) o;
            boolean nameEquals = (this.name == null && other.getName() == null) || (this.name != null && this.name.equals(other.getName()));
            boolean modelEquals = (this.model == null && other.getModel() == null) || (this.model != null && this.model.equals(other.getModel()));
            boolean priceEquals = this.price == other.getPrice();
            boolean yearOfManufactureEquals = this.yearOfManufacture == other.getYearOfManufacture();
            boolean manufacturerListEquals = (this.manufacturerList == null && other.getManufacturerList() == null) || (this.manufacturerList!=null && this.manufacturerList.equals(other.getManufacturerList()));
            boolean engineTypeEquals = (this.engineType == null && other.getEngineType() == null) || (this.engineType.equals(other.getEngineType()));

            return nameEquals && modelEquals && priceEquals && yearOfManufactureEquals && manufacturerListEquals && engineTypeEquals;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Car{");
            sb.append("year='").append(yearOfManufacture).append('\'');
            sb.append("name='").append(name).append('\'');
            sb.append(", model='").append(model).append('\'');
            sb.append(", price=").append(price);
            sb.append(", engineType=").append(engineType);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {


        Manufacturer manufacturer = new Manufacturer("Tesla", 2011, "USA");
        Car car = new Car("Tesla", "Model Y", 35000, 2011, Arrays.asList(manufacturer), EngineType.V8);
        System.out.println(manufacturer);
    }
}
