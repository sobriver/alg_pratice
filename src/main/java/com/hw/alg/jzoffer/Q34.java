package com.hw.alg.jzoffer;

import com.hw.alg.base.TreeNode;

import java.util.Stack;

public class Q34 {



    //查找二叉树中和为某一值的路径
    public void findPath(TreeNode root, int except){
        if (root == null)
            return;

        Stack<Integer> path = new Stack<>();
        int currentSum = 0;
        findPath1(root, except, currentSum, path);

    }

    public void findPath1(TreeNode root, int except, int currentSum, Stack<Integer> path){
        currentSum = currentSum + root.value;
        path.push(root.value);
        //判断是否是叶子节点
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && except == currentSum){
            System.out.println(path.toString());
        }

        //非叶子节点需要遍历
        if (root.left != null){
            findPath1(root.left, except, currentSum, path);
        }

        if (root.right != null){
            findPath1(root.right, except, currentSum, path);
        }

        //返回上一个节点
        path.pop();

    }
}
