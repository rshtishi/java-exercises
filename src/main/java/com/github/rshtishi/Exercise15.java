package com.github.rshtishi;

public class Exercise15 {

    static enum Car {

        FERRARI() {
            @Override
            public boolean isRegular() {
                return false;
            }
            @Override
            public boolean isPremiun() {
                return true;
            }
        },
        PORSCHE() {
            @Override
            public boolean isRegular() {
                return false;
            }
            @Override
            public boolean isPremiun() {
                return true;
            }
        }, MERCEDES() {
            @Override
            public boolean isRegular() {
                return false;
            }
            @Override
            public boolean isPremiun() {
                return true;
            }
        }, BMW() {
            @Override
            public boolean isRegular() {
                return false;
            }
            @Override
            public boolean isPremiun() {
                return true;
            }
        }, OPEL() {
            @Override
            public boolean isRegular() {
                return true;
            }
            @Override
            public boolean isPremiun() {
                return false;
            }
        }, FIAT() {
            @Override
            public boolean isRegular() {
                return true;
            }
            @Override
            public boolean isPremiun() {
                return false;
            }
        }, TOYOTA() {
            @Override
            public boolean isRegular() {
                return true;
            }
            @Override
            public boolean isPremiun() {
                return false;
            }
        };


        public boolean isRegular() {
            return false;
        }

        public boolean isPremiun() {
            return false;
        }

        public boolean isFasterThan(Car car){
            return this.compareTo(car)>0;
        }
    }

    public static void main(String[] args) {

        System.out.println(Car.TOYOTA.isFasterThan(Car.BMW));
        System.out.println(Car.TOYOTA.isPremiun());
        System.out.println(Car.TOYOTA.isRegular());
    }
}
