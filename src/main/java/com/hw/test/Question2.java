package com.hw.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//交替打印
public class Question2 {
    public boolean flag;
    private Lock lock = new ReentrantLock();
    private final Condition isEven = lock.newCondition();// 偶数
    private final Condition isNotEven = lock.newCondition();// 奇数

    public class OddClass implements Runnable {
        public Question2 t;
        public OddClass(Question2 t) {
            this.t = t;
        }
        @Override
        public void run() {
            int i = 1;
            while (i < 10) {
                lock.lock();
                if (!t.flag) {
                    System.out.println(i);
                    i += 2;
                    t.flag = true;
                    isNotEven.signal();
                } else {
                    try {
                        isEven.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }
    }

    public class EvenClass implements Runnable {
        public Question2 t;
        public EvenClass(Question2 t) {
            this.t = t;
        }
        @Override
        public void run() {
            int i = 2;
            while (i <= 10) {
                lock.lock();
                if (t.flag) {
                    System.out.println(i);
                    i += 2;
                    t.flag = false;
                    isEven.signal();
                } else {
                    try {
                        isNotEven.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Question2 tt = new Question2();
        OddClass jiClass = tt.new OddClass(tt);
        EvenClass ouClass = tt.new EvenClass(tt);
        new Thread(jiClass).start();
        new Thread(ouClass).start();
    }


}
