package com.github.rshtishi;

import java.util.Arrays;
import java.util.List;

public class Exercise8Test {

    public static interface Validator {
        boolean validate(Parcel input);
    }

    public static class ParcelSumValidator implements Validator {

        @Override
        public boolean validate(Parcel input) {
            if (Integer.sum(Integer.sum(input.getxLength(), input.getyLength()), input.getZlength()) > 300) {
                System.out.println("Error: validation rule sum of x,y,z<300 not abided");
                return false;
            }
            return true;
        }
    }

    public static class ParcelDimensionSizeValidator implements Validator {

        @Override
        public boolean validate(Parcel input) {
            if (input.getxLength() < 30 || input.getyLength() < 30 || input.getZlength() < 30) {
                System.out.println("Error: validation rule x,y,z<30 not abided");
                return false;
            }
            return true;
        }
    }

    public static class ParcelWeightValidator implements Validator {

        @Override
        public boolean validate(Parcel input) {
            if (input.isExpress() == false && input.getWeight() > 30) {
                System.out.println("Error: validation rule when express is true weight is not <30");
                return false;
            }
            if (input.isExpress == true && input.getWeight() > 15) {
                System.out.println("Error: validation rule when express is false weight is not <15");
                return false;
            }

            return true;
        }
    }

    public static class Parcel {
        private int xLength;
        private int yLength;
        private int zlength;
        private float weight;
        private boolean isExpress;

        public Parcel(int xLength, int yLength, int zlength, float weight, boolean isExpress) {
            this.xLength = xLength;
            this.yLength = yLength;
            this.zlength = zlength;
            this.weight = weight;
            this.isExpress = isExpress;
        }

        public int getxLength() {
            return xLength;
        }

        public int getyLength() {
            return yLength;
        }

        public int getZlength() {
            return zlength;
        }

        public float getWeight() {
            return weight;
        }

        public boolean isExpress() {
            return isExpress;
        }
    }

    public static void main(String[] args) {


        List<Validator> validatorList = Arrays.asList(new ParcelSumValidator(),
                new ParcelDimensionSizeValidator(),
                new ParcelWeightValidator());

        Parcel validParcel = new Parcel(30, 30, 30, 10, true);
        System.out.println(validateParcel(validParcel,validatorList));

        Parcel invalidParcel1 = new Parcel(301, 0, 0, 0, true);
        System.out.println(validateParcel(invalidParcel1,validatorList));

        Parcel invalidParcel2 = new Parcel(50, 0, 0, 0, true);
        System.out.println(validateParcel(invalidParcel2,validatorList));


    }

    public static boolean validateParcel(Parcel parcel, List<Validator> list) {
        for(Validator validator: list){
            if(validator.validate(parcel)==false){
                return false;
            }
        }
        return true;
    }
}
