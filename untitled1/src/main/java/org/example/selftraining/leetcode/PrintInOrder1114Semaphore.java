package org.example.selftraining.leetcode;

import java.util.concurrent.Semaphore;

public class PrintInOrder1114Semaphore {
    private final Semaphore semaphore1 = new Semaphore(0);
    private final Semaphore semaphore2 = new Semaphore(0);


    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire();
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        printThird.run();
    }
}