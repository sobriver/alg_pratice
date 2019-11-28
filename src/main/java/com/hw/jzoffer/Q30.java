package com.hw.jzoffer;


import java.util.Stack;

/**
 * 实现一个栈结构,要求push, pop, min(求栈中的最小值)的操作都为O(1)
 */
public class Q30 {


    public static void main(String[] args) throws Exception{
        MinStack minStack = new MinStack();
        minStack.push(12);
        minStack.push(1);
        minStack.push(3);
        System.out.println(minStack.min()); //1

        minStack.push(23);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());//12

        minStack.push(-4);
        System.out.println(minStack.min()); //-4
    }


    static class MinStack {
        private Stack<Integer> data = new Stack<>(); //存放数据
        private Stack<Integer> min = new Stack<>(); //存放最小值

        //压栈
        void push(int value){
            data.push(value);

            if (min.isEmpty() || value < min.peek()){
                min.push(value);
            } else {
                min.push(min.peek());
            }
        }

        //出栈
        void pop() throws Exception{
            if (!data.isEmpty() && !min.isEmpty()){
                data.pop();
                min.pop();
            } else {
                throw new Exception("stack empty");
            }
        }

        int min() throws Exception {
            if (!min.isEmpty()){
                return min.peek();
            }
            throw new Exception("stack empty");
        }



    }



}
