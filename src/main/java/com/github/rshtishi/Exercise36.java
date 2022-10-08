package com.github.rshtishi;

public class Exercise36 {

    public static class ThreadPlaygroundRunnable implements Runnable {

        private String name;

        public ThreadPlaygroundRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + name + " " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadPlaygroundRunnable("Center"));
        Thread thread2 = new Thread(new ThreadPlaygroundRunnable("East"));
        thread1.start();
        thread2.start();
    }
}
