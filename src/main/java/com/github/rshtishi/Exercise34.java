package com.github.rshtishi;

public class Exercise34 {

    public static class MyThread extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();
    }
}
