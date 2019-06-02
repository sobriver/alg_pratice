package com.hw.alg.string;

/**
 * @author hw
 * @date 2019/6/1 21:35
 * @desc
 */
public class StringTest {

    public static void main(String[] args) {
        System.out.println(reverse("huaasd"));
    }


    /**
     * 反转字符串，使用递归方式实现
     * @param s
     * @return
     */
    static String reverse(String s){
        if (s.length() <= 1) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }

}
