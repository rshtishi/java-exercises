package com.github.rshtishi;

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
            if (input.getxLength() >= 30 && input.getyLength() >= 30 && input.getzLength() >= 30
                    && Integer.sum(Integer.sum(input.getxLength(), input.getyLength()), input.getzLength()) <= 300) {
                return false;
            }
            if (input.getWeight() <= 30 && input.isExpress == false) {
                return false;
            }
            if(input.getWeight()<=15 && input.isExpress()==true){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {

        Validator validator = new ParcelValidator();
        System.out.println(validator.validate(new Parcel()));
    }
}
