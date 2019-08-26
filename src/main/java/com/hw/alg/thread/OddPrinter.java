package com.hw.alg.thread;

/**
 * @author hw
 * @date 2019/7/8 10:36
 * @desc 实现： 两个线程交替打印奇数和偶数
 * 使用wait,notify实现
 */
public class OddPrinter {
    static final Object lock = new Object();
    static int num1 = 0;
    static int num2 = 1;
    static int end = 20;

    volatile static int state = 0;


    public static void main(String[] args) {
        Thread a = new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        if (state == 1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        state = 1;
                        if (num1 >= end)
                            break;
                        System.out.println(Thread.currentThread().getName() + ":" + num1);
                        num1 += 2;

                        lock.notify();
                    }
                }
            }
        };


        Thread b = new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        if (state == 0){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        state = 0;
                        if (num2 >= end)
                            break;
                        System.out.println(Thread.currentThread().getName() + ":" + num2);
                        num2 += 2;
                        lock.notify();
                    }
                }

            }
        };

        a.start();
        b.start();
    }







}
