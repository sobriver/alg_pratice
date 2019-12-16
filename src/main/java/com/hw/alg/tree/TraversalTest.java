package com.hw.alg.tree;

import com.hw.alg.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hw
 * @date 2019/7/23 23:15
 * @desc 二叉树遍历
 * 注意:二叉树的前中后遍历可以理解为根节点是在什么时候被遍历的,
 * 若根节点是第一个被遍历,则为前序,
 * 若根节点是中间被遍历的,则为中序,
 * 若根节点是最后被遍历的,则为后序
 * 其中左右节点都是按照先左后右的顺序遍历
 */
public class TraversalTest {

    public static void main(String[] args) {
        /**
         * 二叉树结构如下:
         *              6
         *             / \
         *             2  8
         *            / \  \
         *           0   4  9
         *           \    \
         *           1    5
         */
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node8;
        node2.left = node0;
        node2.right = node4;
        node8.right = node9;
        node0.right = node1;
        node4.right = node5;

//        preTraversal1(node6);
        levelTraversal(root);


    }


    /**
     * 前序遍历: 先遍历根节点,再遍历左节点,最后遍历右节点
     * 输出如下: 6 2 0 1 4 5 8 9
     * 下面是递归写法
     * 递归函数: 前序遍历打印以node为根节点的二叉树
     * 递归终止: node为null
     * 递归表达式:
     */
    public static void preTraversal1(TreeNode node){
        if (node == null)
            return;
        System.out.println(node.value);
        preTraversal1(node.left);
        preTraversal1(node.right);
    }

    /**
     * 前序遍历: 非递归写法
     *
     */


    /**
     * 中序遍历: 先遍历左节点,再访问根节点,最后访问右节点
     * 输出: 0 1 2 4 5 6 8 9
     */
    public static void midTraversal1(){

    }


    /**
     * 后序遍历: 先遍历左节点,再访问右节点,最后访问根节点
     * 输出: 0 1 2 4 5 6 8 9
     */
    public static void postTraversal1(){

    }


    /**
     * 层序遍历: 即一层一层的去遍历,又叫广度优先遍历
     * 输出: 6 2 8 0 4  9 1 5
     * 使用队列实现,先将根节点入队列,然后只要队列不为空,就出队列,并打印,然后访问节点的左右子树依次入队列
     */
    public static void levelTraversal(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//入队

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll(); //出队
            System.out.println(temp.value);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

    }
}
