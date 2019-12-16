package com.hw.alg.base;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

    /**
     * 打印所有节点的值, 层序打印
     * @param root 根节点
     */
    public static void print(TreeNode root){
        StringBuilder s = new StringBuilder();
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//入队
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll(); //出队
            s.append(temp.value + "-");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

        System.out.println(s.toString());
    }
}
