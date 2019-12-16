package com.hw.alg.mianshi;


/**
 * 听云面试题
 */
public class TingYun {

    /**
     *
     * 题目: 将ori字符串中所有出现的from替换为to, 返回替换后的值
     *
     */
    public String replace(String ori, String from, String to){
        StringBuilder sb = new StringBuilder();

        return null;
    }


    /**
     * 题目: 判断一个数是否为2的幂
     * 思路: 使用递归,每次缩小一半来计算
     */
    public boolean isPower1(long n){
        if (n == 1)
            return true;
        if (n % 2 != 0)
            return false;
        return isPower1(n / 2);
    }

    /**
     * 题目: 判断一个数是否为2的幂
     * 思路: 使用位运算
     */
    public boolean isPower2(long n){
        if (n == 1)
            return true;
        if (n % 2 != 0)
            return false;
        if((n & n - 1) == 0 )
            return true;
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new TingYun().isPower1(32));
        System.out.println(new TingYun().isPower1(24));
    }
}
