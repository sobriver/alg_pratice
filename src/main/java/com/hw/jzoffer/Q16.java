package com.hw.jzoffer;

/**
 * 求数值的整数次方
 * 思路: 常规思路是直接循环相乘,但此法需要计算n-1次乘法,可考虑递归,
 * a^n = a^(n/2) * a^(n/2)
 */
public class Q16 {

    public static long power(long base, long n){
        if (n == 0)
            return 1;
        long abs;
        if (n < 0)
            abs = -n;

        boolean odd = false; //是否奇数,默认否

        return 112;

    }

    //计算n次方,参数都为正数
    public static long powerWithPos(long base, long n){


        if ( n % 2 == 0){//偶数
           long result = powerWithPos(base, n/2);
        } else {//奇数

        }

        return 112;


    }


}
