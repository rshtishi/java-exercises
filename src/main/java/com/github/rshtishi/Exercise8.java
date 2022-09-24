package com.github.rshtishi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Exercise8 {

    static interface Validator {
        boolean validate(Parcel input);
    }

    static class Parcel {
        private int xLength;
        private int yLength;
        private int zLength;
        private float weight;
        private boolean isExpress;

        public int getxLength() {
            return xLength;
        }

        public void setxLength(int xLength) {
            this.xLength = xLength;
        }

        public int getyLength() {
            return yLength;
        }

        public void setyLength(int yLength) {
            this.yLength = yLength;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }

        public boolean isExpress() {
            return isExpress;
        }

        public void setExpress(boolean express) {
            isExpress = express;
        }

        public int getzLength() {
            return zLength;
        }

        public void setzLength(int zLength) {
            this.zLength = zLength;
        }
    }

    static class ParcelValidator implements Validator {

        @Override
        public boolean validate(Parcel input) {
            if (input.getxLength() >= 30 || input.getyLength() >= 30 || input.getzLength() >= 30
                    || Integer.sum(Integer.sum(input.getxLength(), input.getyLength()), input.getzLength()) <= 300) {
                return false;
            }
            if (input.getWeight() >= 15 && input.isExpress() == true) {
                return false;
            }
            if (input.getWeight() >= 30 && input.isExpress() == false) {
                return false;
            }
            return true;
        }
    }

    static class DimensionSizeValidator implements Validator {

        @Override
        public boolean validate(Parcel input) {
            if (input.getxLength() >= 30 || input.getyLength() >= 30 || input.getzLength() >= 30) {
                return false;
            }
            return true;
        }
    }

    static class DimensionSumValidator implements Validator {
        @Override
        public boolean validate(Parcel input) {
            if (Integer.sum(Integer.sum(input.getxLength(), input.getyLength()), input.getzLength()) <= 300) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {

        //Validator validator = new ParcelValidator();
        //System.out.println(validator.validate(new Parcel()));

        List<Validator> validators = new ArrayList<>();
        validators.add(new DimensionSizeValidator());
        validators.add(new DimensionSumValidator());
        validators.add(new Validator() {
            @Override
            public boolean validate(Parcel input) {
                if (input.getWeight() >= 15 && input.isExpress() == true) {
                    return false;
                }
                return false;
            }
        });
        validators.add(input -> {
            if (input.getWeight() >= 30 && input.isExpress() == false) {
                return false;
            }
            return true;
        });

        Parcel parcel = new Parcel();
        boolean isParcelValid = true;

        for (Validator validator : validators) {
            isParcelValid = validator.validate(parcel);
            if (isParcelValid) {
                break;
            }
        }

        System.out.println(isParcelValid);


    }
}
