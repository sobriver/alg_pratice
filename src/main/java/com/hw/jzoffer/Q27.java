package com.hw.jzoffer;


import com.hw.base.TreeNode;
import com.hw.base.TreeUtils;

/**
 * 求一棵二叉树的镜像
 */
public class Q27 {

    /**
     * 求一颗二叉树的镜像二叉树
     * 递归终止条件: 达到树的叶子节点(也就是该节点既没有左树叶没有右树)
     * 递归等价条件: 首先交换根节点的左右节点的值,然后对左右节点再分别递归调用
     * 此处与前序遍历二叉树有点类似,即先遍历根节点,再遍历左节点,再遍历右节点
     * @param root
     */
    public void mirror(TreeNode root){
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        //交换左右节点值
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null){
            mirror(root.left);
        }

        if (root.right != null){
            mirror(root.right);
        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node21 = new TreeNode(6);
        TreeNode node22 = new TreeNode(10);
        TreeNode node31 = new TreeNode(5);
        TreeNode node32 = new TreeNode(7);
        TreeNode node33 = new TreeNode(9);
        TreeNode node34 = new TreeNode(11);
        root.left = node21;
        root.right = node22;
        node21.left = node31;
        node21.right = node32;
        node22.left = node33;
        node22.right = node34;

        TreeUtils.print(root);
        new Q27().mirror(root);
        TreeUtils.print(root);



    }
}
