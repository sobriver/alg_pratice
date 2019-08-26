package com.hw.alg.string;

/**
 * @author hw
 * @date 2019/8/14 21:40
 * @desc
 */
public class GetMaxNum {

    /**
     * 题目: 在字符串中找出连续最长的数字串，并把这个串的长度返回；
     * @param s
     * @return
     */
    static int getMaxNumber(String s){
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i=0; i < chars.length; i++){
            if (Character.isDigit(chars[i])){
                start = i;
                end = i + 1;
            } else {
                start = i;
                end = i;
            }
        }
        return end - start + 1;
    }


    public static void main(String[] args) {
        System.out.println(getMaxNumber("dfd78kj98g9999l0934"));
    }
}
