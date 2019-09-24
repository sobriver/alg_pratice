
package com.hw.other;


/**
 * finally 测试
 */
public class FinalTest {

    public static void main(String[] args) {

        String tar = "acc_release_1.0.2.apk";
        String re = "acc_release_[0-9]\\.[0-9]\\.[0-9]\\.apk";
        System.out.println(tar.matches(re));

        /**
         * 此例说明两点:
         * 1. 即使使用了return语句,finally内部的逻辑仍然执行
         * 2. 第一个return的地方就是函数的真正返回值
         */
//        System.out.println(getInt());
    }


    private static int getInt(){
        int a = 1;
        try {
            a = 2;
            System.out.println(a);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a = 4;
            System.out.println(a);
        }

        return a;

    }
}
