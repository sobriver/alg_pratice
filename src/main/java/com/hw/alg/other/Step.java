package com.hw.alg.other;

/**
 * @author hw
 * @date 2019/6/23 14:48
 * @desc 台阶相关问题
 */
public class Step {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(computeCompl(40));
        System.out.println((System.currentTimeMillis() - start));
    }


    /**
     * 问题：假设有n级台阶，每次只能走1步或者2步，问总共有几种走法？
     * 思路1：比较简单的想法是裴波数列的递归思想，第n级台阶的走法是第n-1级走法和第n-2级台阶走法的和
     * 数学表达式 f(n)=f(n-1)+f(n-2)
     * todo 该解法当n较大时，效率极其低下,因为每个值被多次重复计算
     */
    static long computeSimple(long  n){
        if (n <= 2)
            return n;
        return computeSimple(n - 1) + computeSimple(n - 2);
    }

    /**
     * 问题：假设有n级台阶，每次只能走1步或者2步，问总共有几种走法？
     * 思路： 上面方法使用递归时，由于每个值都要重复计算多次，当n较大时，差距明显扩大。例如当n=40,上面方法耗时41577ms,
     * 本方法消耗1ms;
     * 使用迭代，相当于将上一次的计算结果缓存起来
     * @param n
     * @return
     */
    static long computeBetter(long n){
        if (n <= 2)
            return n;
        long front = 1; //第一个指针
        long next = 2; //第二个指针
        long sum = 0;
        for (long i=3; i<= n; i++){
            sum = front + next;
            //每次计算完成后，需要移动第一个和第二个指针，其中第一个指针移到原先第二个指针的地方，第二个指针移到本次计算结果处
            front = next;
            next = sum;
        }
        return sum;
    }

    /**
     * 问题：假设有n级台阶，每次走的步数为1到n中的任何一个数，问总共有几种走法？
     * 思路：一种仍然是递归，效率太低，不做考虑。此处可以使用概率论的知识，每个台阶只有两种状态，要么跳，要么不跳，
     * 最后一级台阶除外，因为最后一级台阶一定要跳，这样总共2^(n-1)
     * todo 这地方有点不懂，如果这样可以的话，那么对于简单台阶问题，每一级台阶不也都是每次只有跳或者不跳的状态吗？
     */
    static long computeCompl(long n){
        return (long) Math.pow(2, n - 1);
    }
}
