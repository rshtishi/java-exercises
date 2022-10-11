package com.github.rshtishi;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class Exercise39 {

    public static class Result {

        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private Lock readLock = readWriteLock.readLock();
        private Lock writeLock = readWriteLock.writeLock();

        public final static int SIZE = 10;
        private int[] results = new int[SIZE];

        public void update(int[] results) {
            writeLock.lock();
            try {
                this.results = results;
            } finally {
                writeLock.unlock();
            }
        }

        public int[] read() {
            readLock.lock();
            try {
                return results;
            } finally {
                readLock.unlock();
            }
        }
    }

    public static class Sensor implements Runnable {

        private Result result;

        public Sensor(Result result) {
            this.result = result;

        }

        @Override
        public void run() {
            while (true) {
                int sleepTime = new Random().nextInt(1000);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int[] values = result.read();
                values = IntStream.of(values).map(value -> value + new Random().nextInt(10)).toArray();
                result.update(values);
            }
        }
    }

    public static class Screen implements Runnable {

        private Result result;

        public Screen(Result result) {
            this.result = result;
        }


        @Override
        public void run() {
            while (true) {
                System.out.println("Screen name: " + Thread.currentThread().getName());
                int[] values = result.read();
                for (int i = 0; i < values.length; i++) {
                    System.out.print("result " + i + ": " + values[i] + ";");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Result result = new Result();
        executor.execute(new Sensor(result));
        executor.execute(new Sensor(result));
        executor.execute(new Screen(result));
        executor.execute(new Screen(result));

        executor.shutdown();
    }
}
