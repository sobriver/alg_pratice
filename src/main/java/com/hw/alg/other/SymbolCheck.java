package com.hw.alg.other;
import java.util.Stack;

/**
 * @author hw
 * @date 2019/8/14 20:54
 * @desc
 */
public class SymbolCheck {


    /**
     * 题目:校验输入字符的括号是否匹配,如 [][[]]是匹配的
     * 思路: 利用栈,先将第一个字符入栈,然后比较第二个字符与前一个是否匹配,若匹配则将前一个出栈,否则入栈,
     * 一直进行下去,最后比较栈是否为空,若为空则表明是相互匹配的,则为true, 否则false
     * @param s
     * @return true 匹配, false 匹配
     */
    static boolean isValidate(String s){
        //若位数是奇数,肯定不匹配
        if (s.length() % 2 != 0)
            return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);

        //注意: stack.peek()只读出栈顶元素,不出栈
        //stack.pop()读出栈顶元素,并将该元素出栈
        for (int i=1; i < chars.length; i++){//注意此处循环需要从第二个数开始
            char c = chars[i];
            if (stack.isEmpty()){
                //此处空的时候也需要push进去,防止之前已经匹配完毕导致栈为空,见t6()测试案例
                stack.push(c);
            }else if ((c == '[' && stack.peek() == '[') || (c == ']' && stack.peek() == ']')){
                //当之前一个字符和现在的字符相同,就放入栈中
                stack.push(c);
            } else if (stack.peek() == '[' && c == ']'){
                //当栈中的字符是左括号且当前字符是右括号,则说明是匹配的,弹出,注意此处括号顺序必须保持这样,否则对于"]["这种也将会匹配
                stack.pop();
            }
        }

        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "[]";
        String s2 = "[[[]]][][]";
        String s3 = "[]][";
        System.out.println(isValidate(s1));
    }


}
