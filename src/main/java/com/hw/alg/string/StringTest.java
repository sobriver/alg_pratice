package com.hw.alg.string;

/**
 * @author hw
 * @date 2019/6/1 21:35
 * @desc
 */
public class StringTest {

    public static void main(String[] args) {
        System.out.println(string2Int("jloj762jf89J0"));
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

    /**
     * 将一个String转化为int
     */
    static int string2Int(String s){
        int len = s.length();

        int result = 0;
        for (int i=0; i < len; i++){
            int c = Character.digit(s.charAt(i), 10);
            if (c <= 9 && c >= 0){
                result = result * 10 + c;
            }
        }
        return result;

    }

}
