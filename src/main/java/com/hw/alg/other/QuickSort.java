package com.hw.alg.other;

import java.util.Arrays;

/**
 * @author hw
 * @date 2019/8/11 22:37
 * @desc 快速排序
 * 时间复杂度: O(nlogn)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 1, 23};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }


    /**
     * 划分数组,使比基准值小的数都在基准值左边,比基准值大的数都在基准值右边
     * 这里基准值取最后一个数
     * @param a
     * @param start
     * @param end
     * @return 排序完成之后基准值所处的位置
     */
    public static int divide(int[] a, int start, int end){
        int base = a[end];

        while (start < end){
            //先从左边往右边,找到比基准值大的数
            while (start < end && a[start] <= base)
                start++;
            if (start < end){// 上面的循环结束,表明此时找到了一个比base大的值,开始交换a[start]和base
                int temp = a[start];
                a[start] = base;
                base = temp;
                //交换之后,那个被交换的值调到了基准值的右边,因此右边也需要向前移动一位
                end--;
            }


            //再从右边往左边,找到比基准值小的数
            while (start < end && a[end] > base)
                end--;
            if (start < end){//交换a[end]和base值
                int temp = a[end];
                a[end] = base;
                base = temp;
                start++;
            }

        }
        return end;//此处返回start也一样,因为此时已经重合了
    }

    public static void sort(int[] a, int start, int end){
        if (start > end)
            return;
        //第一次排序完之后基准值的位置
        int dividePosition = divide(a, start, end);
        //左右两边再进行排序
        sort(a, start, dividePosition-1);
        sort(a, dividePosition+1, end);
    }


}
