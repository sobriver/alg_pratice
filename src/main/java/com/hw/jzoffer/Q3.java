package com.hw.jzoffer;
public class Q3 {
    /**
     * 题目: 找出数组中重复的数字
     * 在一个长度为n的数组中所有数字都在0到n-1的范围内,数组中某些项是重复的,请找出数组中任意一个重复的数字,若无重复项,返回-1
     * 示例: [2,3,1,0,2,5,3] 输出是2或者3
     * 思路: 可以预见,当数组中没有重复元素时,数组每一项的值刚好和数组下标对应.如果数组中有重复项,肯定会导致某些项重复,而某些项没有.
     * 遍历数组,当数组项值与其下标相等时,则继续比较下一项.
     * 当数组项值与其下标不相等时,比较数组项值与数组项值对应的数组项值,若两者相等,则表明存在两个重复的数字,结束循环.
     * 若不相等,则交换这两个值,如此循环进行下去
     * 时间复杂度: O(n),此处不是很理解为什么是这个值
     */
    public static int duplicateNum(int[] a){
        if (a == null ||  a.length == 0) {
            return -2;
        }
        //检查数组每一项若超过范围,则表明数组不符合规范,退出
        for (int value: a){
            if (value < 0 || value > a.length-1 ){
                return -2;
            }
        }
        for (int i = 0; i < a.length; i++) {
            while (a[i] != i){
                if (a[i] == a[a[i]]){
                    return a[i];
                }
                //不相等时,交换a[i]和a[a[i]]的值
                int tmp = a[i];
                a[i] = a[tmp];
                a[tmp] = tmp;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1,3,4,0,2,5,3,1};
        System.out.println(duplicateNum(a));
    }


}
