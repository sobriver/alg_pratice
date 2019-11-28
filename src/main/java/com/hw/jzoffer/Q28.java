package com.hw.jzoffer;


import com.hw.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目:判断一个二叉树是不是对称的
 */
public class Q28 {


    /**
     *
     * 递归解法
     *  解析: 若一颗二叉树是对称的,则它的左子树和右子树是镜像对称的,那么什么时候左子树和右子树是镜像对称的呢?
     *  需要同时满足以下三点:
     *  1. 左子树和右子树根节点的值相同
     *  2. 左子树根节点的左子树和右子树根节点的右子树镜像对称
     *  3. 左子树根节点的右子树和右子树根节点的左子树镜像对称
     * @param root
     * @return
     */
    public boolean isMirror(TreeNode root){
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }


    /**
     * 递归函数目的: 判断以root1为根节点的二叉树是否和以root2为根节点的二叉树镜像对称
     * 递归终止条件: root1,root2出现null
     * 递归表达式: 节点值相同且左右对称
     * 时间复杂度: O(n), n表示树的节点个数
     * 空间复杂度: O(n)
     * @param root1
     * @param root2
     * @return
     */
    public boolean isMirror(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        return (root1.value == root2.value) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }


    /**
     * 迭代解法
     * 解析: 再复制一颗相同的树和一个队列来解决.思想有点类似于树的广度优先遍历
     * 假设这两颗相同的树为t1, t2
     * 每次插入队列的顺序: t1的左节点, t2的右节点, t1的右节点, t2的左节点
     * 然后每次从队列中弹出两个节点.
     * 若树是对称的,则每次弹出的两个节点值都相同,只要出现节点值不同就是非对称的;
     * 当队列为空时,此时表明树已经遍历到叶子节点,仍然都对称,则该二叉树一定是对称的
     * @param
     */
     public boolean isMirror2(TreeNode root){
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         queue.add(root);

         while (!queue.isEmpty()){
             TreeNode node1 = queue.poll();
             TreeNode node2 = queue.poll();

             //todo 该处为何是continue不是很理解
             if (node1 == null && node2 == null)
                 continue;
             //这两者任何一个出现null,表明树的左右节点有一个为null,肯定不对称
             if (node1 == null || node2 == null)
                 return false;
             //两个节点的值不相同,则肯定不相同
             if (node1.value != node2.value)
                 return false;

             //添加元素
             queue.add(node1.left);
             queue.add(node2.right);
             queue.add(node1.right);
             queue.add(node2.left);
         }
         return true;

     }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node21 = new TreeNode(3);
        TreeNode node22 = new TreeNode(3);

        TreeNode node31 = new TreeNode(4);
        TreeNode node32 = new TreeNode(4);

        TreeNode node41 = new TreeNode(3);

        root.left = node21;
        root.right = node22;
        node21.left = node31;
        node22.right = node32;
        node31.left = node41;

        System.out.println(new Q28().isMirror2(root));
    }
}
