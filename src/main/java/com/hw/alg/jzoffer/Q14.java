package com.hw.alg.jzoffer;

public class Q14 {

    /**
     * 题目:有一个长度为l的绳子,请把绳子剪成m段(m,n都为整数),使得m段绳子的乘积最大,并返回最大值
     * 如l=8,则剪成2,3,3时得到的乘积最大,为18
     * 解析: 使用动态规划的思想.假设f(n)表示长度为n的绳子剪成m段后乘积的最大值,则现在随便在i处剪断,则这两段绳子剪法的最大值为f(i)和f(n-i),
     * 且 f(n)=max(f(i) * f(n-i)),这是一个递归,科考虑使用循环来从下往上计算,减少计算次数
     */
    public int getMax(int length){
        //0,1,2,3时的特例需要特殊处理
        if (length == 0)
            return 0;
        if (length == 1)
            return 1;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        //该数组每一项表示将长为index(数组下标)绳子剪成m段所得到的乘积最大值
        int[] arr = new int[length+1];
        //todo 这几项取值不是很明白
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        int max = 0;
        for (int i=4; i <= length; i++){
            max = 0;

            for (int j = 1; j <= i / 2; j++){
                int tmp = arr[j] * arr[i-j];
                if (tmp > max)
                    max = tmp;
                arr[i] = max;

            }

        }
        max = arr[length];
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Q14().getMax(8));
    }
}
