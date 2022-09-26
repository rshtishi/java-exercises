package com.github.rshtishi;

public class Exercise17 {

    public static interface Converter {
        public double convert(int value);
    }

    public static class MetersToYards implements Converter {
        public final static double METER_TO_YARD = 1.09361;

        @Override
        public double convert(int value) {
            return value * METER_TO_YARD;
        }
    }

    public static class YardsToMeter implements Converter {
        private static final double YARD_TO_METER = 0.9144;

        @Override
        public double convert(int value) {
            return value * YARD_TO_METER;
        }
    }

    public static class CentimeterToInches implements Converter {
        private static final double CENTIMETER_TO_INCH = 0.393701;

        @Override
        public double convert(int value) {
            return value * CENTIMETER_TO_INCH;
        }
    }

    public static class InchesToCentimeter implements Converter {

        public static final double INCH_TO_CENTIMETER = 2.54;

        @Override
        public double convert(int value) {
            return value * INCH_TO_CENTIMETER;
        }
    }

    public static class KilometersToMiles implements Converter {

        public static final double KILOMETER_TO_MILE = 0.621371;

        @Override
        public double convert(int value) {
            return value * KILOMETER_TO_MILE;
        }
    }

    public static class MilesToKilometers implements Converter {

        public static final double MILE_TO_KILOMETER = 1.60934;

        @Override
        public double convert(int value) {
            return value * MILE_TO_KILOMETER;
        }
    }

    static enum ConversionType {
        METERS_TO_YARDS(new MetersToYards()),
        YARDS_TO_METERS(new YardsToMeter()),
        CENTIMETERS_TO_ICHES(new CentimeterToInches()),
        INCHES_TO_CENTIMETERS(new InchesToCentimeter()),
        KILOMETERS_TO_MILES(new KilometersToMiles()),
        MILES_TO_KILOMETERS(new MilesToKilometers());
        private Converter converter;

        private ConversionType(Converter converter) {
            this.converter = converter;
        }

        public double convert(int value) {
            return converter.convert(value);
        }
    }

    public static class MeasurementConverter {
        public double convert(int value, ConversionType conversionType) {
            return conversionType.convert(value);
        }
    }

    public static void main(String[] args) {
        MeasurementConverter measurementConverter = new MeasurementConverter();
        double result = measurementConverter.convert(5,ConversionType.INCHES_TO_CENTIMETERS);
        System.out.println(result);
    }


}
