package com.hw.alg.jzoffer;

/**
 * 裴波拉起数列
 * n=0, f(n)=0,
 * n=1, f(n)=1
 * n>1, f(n)=f(n-1)+f(n-2)
 */
public class Q10 {

    //递归,效率低下,因为许多项会被重复计算
    public static long f1(long n){
        if (n < 0)
            return -1;
        if (n <= 1)
            return n;
        return f1(n-1) + f1(n-2);
    }

    /**
     * 循环,从最小的元素开始算起,每次缓存之前计算的值,防止重复计算
     * 循环的本质可以看做是利用数组的指针不断往后移动,从而得到计算结果.
     */
    public static long f2(long n){
        if (n < 0)
            return -1;
        if (n <= 1)
            return n;
        long p1 = 0;
        long p2 = 1;
        long sum = 0;
        for (int i=2; i<=n; i++){
            sum = p1 + p2;
            //将p1,p2指针都向后移动一位,p1向后移动一位是p2,p2向后移动一位是sum
            p1 = p2;
            p2 = sum;
        }
        return sum;
    }

    /**
     * 青蛙跳台阶问题
     * 一只青蛙,每次只能跳1级台阶或者2级台阶,对于n级台阶,总共有多少种跳法?
     * 分析: 先分析1级和2级,很容易得出分别为1和2.
     * 然后分析一个普通情况,如四级台阶,现在先假设f(n)表示n级台阶的跳法,青蛙第一次跳时,只有两种选择,要么是跳到第一级,要么是跳到第二级
     * 当跳到第一级台阶时,还剩下3级台阶,这三级台阶的跳法为f(3),当跳到第二级台阶时,还剩下2级台阶,这两
     * 级台阶的跳法为f(2), 那么四级台阶的总跳法f(4)=f(3)+f(2) (这两者之间是或的关系,所以是加法)
     * 同理可得f(n) = f(n-1)+f(n-2)
     */

    /**
     *
     * 格子放法问题
     *
     */




    public static void main(String[] args) {
        System.out.println(f1(10));
        System.out.println(f2(10));
    }

}
