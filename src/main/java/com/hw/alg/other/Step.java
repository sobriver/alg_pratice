package com.hw.alg.other;

import java.util.Arrays;

/**
 * @author hw
 * @date 2019/6/23 14:48
 * @desc 台阶相关问题
 */
public class Step {

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        System.out.println(computeCompl(40));
//        System.out.println((System.currentTimeMillis() - start));


        //快速排序算法见: https://blog.csdn.net/IT_ZJYANG/article/details/53406764
        int[] a = {1, 10, 3, 87, 8, 10, 3, 3, 3, 1, 23};
        sort(a, 0, a.length-1);
        System.out.println("l=" + a.length);


       for (int x: a){
           System.out.println(x + " ");
       }
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
            if (start < end){// 上面的循环结束,表明此时找到了一个比base大的值,开始交换a[start]和a[end]
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                //交换之后,那个被交换的值调到了基准值的右边,因此右边也需要向前移动一位
                end--;
            }


            //再从右边往左边,找到比基准值小的数
            while (start < end && a[end] > base)
                end--;
            if (start < end){//交换a[end]和a[start]值
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
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










    /**
     * 问题：假设有n级台阶，每次只能走1步或者2步，问总共有几种走法？
     * 思路1：比较简单的想法是裴波数列的递归思想，第n级台阶的走法是第n-1级走法和第n-2级台阶走法的和
     * 数学表达式 f(n)=f(n-1)+f(n-2)
     * todo 该解法当n较大时，效率极其低下,因为每个值被多次重复计算
     */
    static long computeSimple(long  n){
        if (n <= 2)
            return n;
        return computeSimple(n - 1) + computeSimple(n - 2);
    }

    /**
     * 问题：假设有n级台阶，每次只能走1步或者2步，问总共有几种走法？
     * 思路： 上面方法使用递归时，由于每个值都要重复计算多次，当n较大时，差距明显扩大。例如当n=40,上面方法耗时41577ms,
     * 本方法消耗1ms;
     * 使用迭代，相当于将上一次的计算结果缓存起来
     * @param n
     * @return
     */
    static long computeBetter(long n){
        if (n <= 2)
            return n;
        long front = 1; //第一个指针
        long next = 2; //第二个指针
        long sum = 0;
        for (long i=3; i<= n; i++){
            sum = front + next;
            //每次计算完成后，需要移动第一个和第二个指针，其中第一个指针移到原先第二个指针的地方，第二个指针移到本次计算结果处
            front = next;
            next = sum;
        }
        return sum;
    }

    /**
     * 问题：假设有n级台阶，每次走的步数为1到n中的任何一个数，问总共有几种走法？
     * 思路：一种仍然是递归，效率太低，不做考虑。此处可以使用概率论的知识，每个台阶只有两种状态，要么跳，要么不跳，
     * 最后一级台阶除外，因为最后一级台阶一定要跳，这样总共2^(n-1)
     * todo 这地方有点不懂，如果这样可以的话，那么对于简单台阶问题，每一级台阶不也都是每次只有跳或者不跳的状态吗？
     */
    static long computeCompl(long n){
        return (long) Math.pow(2, n - 1);
    }
}
