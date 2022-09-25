package com.github.rshtishi;

public class Exercise16 {

    static enum Runner {

        BEGINNER(550, 800),
        INTERMEDIATE(450, 549),
        ADVANCED(380, 449);

        private int minTime;
        private int maxTime;

        private Runner(int minTime, int maxTime) {
            this.minTime = minTime;
            this.maxTime = maxTime;
        }

        public static Runner getFitnesLevel(int min) {
            if (min >= 550 && min <= 800) {
                return BEGINNER;
            }
            if (min >= 450 && min <= 549) {
                return INTERMEDIATE;
            }
            if (min >= 380 && min <= 449) {
                return ADVANCED;
            }
            return null;
        }
    }

    public static void main(String[] args) {

        Runner runner = Runner.getFitnesLevel(600);
        System.out.println(runner);
    }
}
