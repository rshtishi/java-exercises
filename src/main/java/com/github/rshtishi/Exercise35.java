package com.github.rshtishi;

public class Exercise35 {

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
