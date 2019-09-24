package com.hw.alg.sort;

import java.util.Arrays;

/**
 * @author hw
 * @date 2019/8/14 21:55
 * @desc 归并排序
 */
public class MergeSort {
    /**
     * 归并排序
     * 主要思路:
     * 1. 取数组的中间值将数组分隔成两个数组(也可以取其他值)
     * 2. 分别对两个数组递归调用本方法,直到数组只剩一个元素为止(此时数组肯定有序)
     * 3. 将分隔后的有序数组进行合并
     *
     * 时间复杂度: 平均: O(nlogn) 最小:O(nlogn) 最大:O(nlogn)
     * 空间复杂度: O(n)
     * 由此可以看见归并排序时间上是很稳定的,缺点是需要消耗额外的内存空间
     */
    private static int[] sort(int[] a){
        //当数组的长度为1,此时肯定是有序的,递归调用结束
        if (a.length <= 1)
            return a;
        int middle = a.length / 2;

        //左边数组
        int[] leftArray = Arrays.copyOfRange(a, 0, middle);
        //右边数组
        int[] rightArray = Arrays.copyOfRange(a, middle, a.length);

        //重点: 递归调用自身
        return mergeArray(sort(leftArray), sort(rightArray));
    }


    /**
     * 将两个有序数组合并成一个有序数组
     * 主要思路:
     * 1.构造一个c数组,作为输出数组
     * 2.准备三个指针,分别指向a,b,c的头部
     * 3.依次比较a,b的值,将较小的值赋值给c,同时赋值的数组指针和c的指针向后移动一位
     * 4.若a,b有任何一个数组的指针已经达到数组末尾,则把另一个数组的值直接全部赋值给c
     * @param a
     * @param b
     * @return 合并后的数组
     */
    private static int[] mergeArray(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int ap = 0; //a指针
        int bp = 0; //b指针
        int cp = 0; //c指针
        //该处条件表示a和b的指针都还没有达到末尾,故需要取出两者中的较小者赋值给c,并移动指针
        while (ap < a.length && bp < b.length){
            if (a[ap] < b[bp]){
                c[cp++] = a[ap++];
            } else {
                c[cp++] = b[bp++];
            }
        }
        //若该条件满足,则表明a数组指针还没到尾部,将剩下的值全部赋值给c
        while (ap < a.length){
            c[cp++] = a[ap++];
        }
        //若该条件满足,则表明b数组指针还没到尾部,将剩下的值全部赋值给c
        while (bp < b.length){
            c[cp++] = b[bp++];
        }
        return c;
    }



    public static void main(String[] args) {
        int[] a = {12, 2, 34, 23, 1, 45};
        System.out.println(Arrays.toString(sort(a)));
    }

}

