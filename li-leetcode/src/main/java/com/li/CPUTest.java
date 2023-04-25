package com.li;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CPUTest {

    private static final int NUM_TASKS = 10;
    private static final int NUM_ITERATIONS = 1000000000;
    private static final double TARGET_SCORE = 100.0;

    public static void main(String[] args) {
//        int numThreads = Runtime.getRuntime().availableProcessors();
        int numThreads = 6;
        System.out.println("Number of available threads: " + numThreads);

        double[] scores = new double[numThreads];
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            executor.submit(() -> {
                long startTime = System.nanoTime();
                for (int j = 0; j < NUM_ITERATIONS; j++) {
                    double result = 1.0 + 1.0 / (double) j;
                }
                long endTime = System.nanoTime();
                double timeInSecs = (endTime - startTime) / 1000000000.0;
                double score = (NUM_ITERATIONS / timeInSecs) / 1000000000.0;
                scores[threadIndex] = score;
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double avgScore = 0;
        for (double score : scores) {
            avgScore += score;
        }
        avgScore /= numThreads;

        double percentScore = avgScore / TARGET_SCORE * 100;
        System.out.printf("CPU score: %.2f / 100.0%n", percentScore);
    }
}


















