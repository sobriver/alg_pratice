package com.hw.alg.jzoffer;

public class Q11 {

    /**
     * 将一个已经排好序的递增数组的前若干个元素放到数组后面,称为数组的旋转.如3,4,5,1,2为1,2,3,4,5的一个旋转,找出该旋转数组的最小值
     * 思路: 由于原数组本身是递增的,因此后面一个元素值肯定大于等于前面一个元素值,只有在衔接处才会出现后面的值小于前面的值,而这个地方刚好是数组的最小值.
     * 因此,准备两个指针,其中p2比p1快一步,然后当p2指向的值小于p1指向的值,此时的p2处就是最小值
     */
    public static int findMin(int[] a){
        if (a.length == 1)
            return a[0];
        int p1 = 0;
        int p2 = 1;

        while (p1 < a.length && p2 < a.length){
            if (a[p2] < a[p1]){
                return a[p2];
            }
            p1++;
            p2++;
        }
        return a[p1];
    }



    public static void main(String[] args) {
        int[] a1 = {1,2,3,0,1};
        int[] a2 = {4,5,2};
        int[] a3 = {1,0,1,1,1};
        int[] a4 = {1,0};
        System.out.println(findMin(a1));
        System.out.println(findMin(a2));
        System.out.println(findMin(a3));
        System.out.println(findMin(a4));

    }
}
