package com.hw.alg.jzoffer;

import java.util.Arrays;

public class Q21 {

    /**
     * 将一个整数数组进行重排,使得所有的奇数都位于数组的前半部分,所有的偶数都位于数组的后半部分
     * 思路: 准备两个指针1,2,分别指向数组的第一个元素和最后一个元素,然后向后移动p1,向前移动p2,如果p1是偶数且p2是奇数,则交换这两个值
     */
    public void order(int[] a){
        if (a.length <= 1)
            return;
        int p1 = 0;
        int p2 = a.length - 1;
        while (p1 < p2){

            //向后移动p1,直到其指向偶数
            while (p1 < p2 && (a[p1] % 2 != 0))
                p1++;
            //向前移动p2,直到其指向奇数666
            while (p1 < p2 && (a[p2] % 2 == 0))
                p2--;
            //交换这两个值
            if (p1 < p2){
                int tmp = a[p1];
                a[p1] = a[p2];
                a[p2] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2,3, 4,5};
        int[] a2 = {4, 2, 2};
        int[] a3 = {3, 1, 7, 9};
        int[] a4 = {4, 1, 3, 2, 10, 11, 24};

        new Q21().order(a1);
        System.out.println(Arrays.toString(a1));
        new Q21().order(a2);
        System.out.println(Arrays.toString(a2));
        new Q21().order(a3);
        System.out.println(Arrays.toString(a3));
        new Q21().order(a4);
        System.out.println(Arrays.toString(a4));

    }
}
