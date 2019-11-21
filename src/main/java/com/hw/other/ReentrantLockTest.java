package com.hw.other;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        for (int i=1; i <= 5; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "get lock success");
                }
            }, "thread-" + i);
            thread.start();
        }







    }
}
