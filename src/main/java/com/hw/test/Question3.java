package com.hw.test;

/**
 * 冒泡排序
 */
public class Question3 {

    public static void sort(int[] a) {
        boolean need = false;
        for (int i = 1; i < a.length && need; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    need = true;
                }
            }
        }
    }
}
