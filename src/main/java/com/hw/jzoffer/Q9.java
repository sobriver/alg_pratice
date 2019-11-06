package com.hw.jzoffer;

import java.util.Stack;

/**
 * 用两个栈实现队列，实现队列从头部删除元素和从尾部加入元素
 * 实现思路： 添加尾部元素时插入1中
 * 删除头部元素时首先判断2是否为空，如果空，则将1中的所有元素都依次压入2中，然后删除2的栈顶元素
 * 
 */
public class Q9 {

    private Stack<String> stack1 = new Stack<>();
    private Stack<String> stack2 = new Stack<>();


    //删除头部元素
    public void deleteHead(){
        if (stack2.isEmpty()){
            if (stack1.isEmpty()){
                return;
            }
            for (String o: stack1){
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    //往尾部添加元素
    public void appendTail(String node){
        stack1.push(node);
    }








}
