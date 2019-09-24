package com.hw.jzoffer;

public class Characepter1 {

    public static void main(String[] args) throws Exception {
        System.out.println(strToInt("-12343422222222222222222"));
    }

    /**
     * 将字符串转化为整数
     * 考虑边界条件,负数取值
     */
    public static int strToInt(String str) throws Exception{
        if (str == null)
            throw new Exception("输入值不合法");
        int len = str.length();
        if (len == 0)
            throw new Exception("输入值不合法");
        boolean negative = false; //是否负数
        int i = 0;
        char firstChar = str.charAt(0);
        if (firstChar == '-'){
            negative = true;
            i++;
        }

        int result = 0; //最终输出结果
        while (i < len){
            int c = Character.digit(str.charAt(i), 10);
            //需要判断是否会超限
            if (negative){
                if (result < (Integer.MIN_VALUE + c) / 10){
                    throw new Exception("小于最小值");
                }
            } else {
                if (result > (Integer.MAX_VALUE - c) / 10){
                    throw new Exception("超过最大值");
                }
            }
            //这一句是精髓，使用类似递归的思想
            result = result * 10 + c;
            i++;
        }
        return negative ? -result : result;

    }


}
