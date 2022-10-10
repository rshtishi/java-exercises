package com.github.rshtishi;

public class Exercise38 {

    public static class CoffeeMachine {

        public Object lock = new Object();

        private int[] waterTank;
        private static final int WATER_TANK_SIZE = 10;
        private int index;

        public CoffeeMachine() {
            waterTank = new int[WATER_TANK_SIZE];
            for (int i = 0; i < WATER_TANK_SIZE; i++) {
                waterTank[i] = 1;
            }
            index = WATER_TANK_SIZE;
        }

        public void refill() {
            if (index == 0) {
                for (int i = 0; i < 10; i++) {
                    waterTank[i] = 1;
                }
                index = WATER_TANK_SIZE;
                System.out.println("Water tank refilled");
            } else {
                throw new IllegalStateException("Tank is not empty");
            }
        }

        public void brew() {
            if (index > 0) {
                index--;
                waterTank[index] = 0;
                System.out.println("Coffee brewed");
            }
        }

        public boolean isTankEmpty() {
            return index == 0;
        }

    }

    public static class BrewCoffee implements Runnable {

        private CoffeeMachine coffeeMachine;

        public BrewCoffee(CoffeeMachine coffeeMachine) {
            this.coffeeMachine = coffeeMachine;
        }

        @Override
        public void run() {
            synchronized (coffeeMachine.lock) {
                while (true) {
                    if (coffeeMachine.isTankEmpty()) {
                        try {
                            coffeeMachine.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    coffeeMachine.brew();
                    if (coffeeMachine.isTankEmpty()) {
                        coffeeMachine.lock.notifyAll();
                    }
                }
            }
        }
    }


    public static class RefillTank implements Runnable {

        private CoffeeMachine coffeeMachine;

        public RefillTank(CoffeeMachine coffeeMachine) {
            this.coffeeMachine = coffeeMachine;
        }

        @Override
        public void run() {
            synchronized (coffeeMachine.lock) {
                while (true) {
                    if (!coffeeMachine.isTankEmpty()) {
                        try {
                            coffeeMachine.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    coffeeMachine.refill();
                    coffeeMachine.lock.notifyAll();
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Thread brewThread = new Thread(new BrewCoffee(coffeeMachine));
        Thread refillThread = new Thread(new RefillTank(coffeeMachine));
        brewThread.start();
        refillThread.start();
        brewThread.join();
        refillThread.join();

    }
}
