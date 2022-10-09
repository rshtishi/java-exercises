package com.github.rshtishi;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Exercise37 {

    public static void main(String[] args) {

        Executor executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executor.execute(new Exercise36.ThreadPlaygroundRunnable("Playground " + i));
        }

    }
}
