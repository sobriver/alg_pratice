package com.hw.jzoffer;

import com.hw.base.TreeNode;

/**
 * 题目: 判断二叉树B是否是二叉树A的子树
 * 解析: 首先判断B的根节点和A的根节点值是否相同,若不相同, 则分别对A根节点的左右节点递归调用.
 * 若相同,此处复杂一点,首先要定义一个函数,函数的功能: 以R(R是上一步求出的相同节点)为根节点的子树是否和B具有相同的结构,
 * 由该函数的返回值也就是本题的求解.该含函数的具体实现也需要使用递归,具体见方法分析
 * todo 此题解法有问题,对于返回false的例子也返回true
 */
public class Q26 {





    /**
     * 二叉树B是否是A的子树
     * 终止条件: A或者B达到叶子节点
     * 等价表达式: 由逻辑决定
     * @param rootA A的根节点
     * @param rootB B的根节点
     * @return
     */
    public  boolean isSubTree(TreeNode rootA, TreeNode rootB){
        boolean re = false;
        if (rootA != null && rootB != null){

            //此处三个条件任何一个满足,即表明B是A的子树,从而不必再去检测后面的条件
            if (rootA.value == rootB.value){
                re = isSame(rootA, rootB);
            }
            if (!re){
                re = isSubTree(rootA.left, rootB);
            }
            if (!re){
                re = isSubTree(rootA.right, rootB);
            }
        }
        return re;
    }


    /**
     * 以rootA为根节点的子树是否具有和B相同的结构
     * 递归终止条件: A或B达到叶子节点
     * 递归等价表达式:
     * 若rootA的值和rootB的值不相等,则肯定不具有相同的结构;
     * 若rootA的值和rootB的值相等,则判断以rootA的左节点为根节点的子树是否具有和以rootB的左节点具有相同的结构(递归调用),
     * 同理, rootA的有节点比较同上;
     *
     * @param rootA
     * @param rootB
     * @return
     */
    public  boolean isSame(TreeNode rootA, TreeNode rootB){

        if (rootB == null)
            return true;
        if (rootA == null)
            return false;

        if (rootA.value != rootB.value)
            return false;

        return isSame(rootA.left, rootB.left) && isSame(rootB.right, rootB.right);

    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode node21 = new TreeNode(8);
        TreeNode node22 = new TreeNode(7);
        TreeNode node31 = new TreeNode(9);
        TreeNode node32 = new TreeNode(2);
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(7);
        root1.left = node21;
        root1.right = node22;
        node21.left = node31;
        node21.right = node32;
        node32.left = node41;
        node32.right = node42;


        TreeNode root2 = new TreeNode(8);
        TreeNode node2_21 = new TreeNode(9);
        TreeNode node2_22 = new TreeNode(8);
        root2.left = node2_21;
        root2.right = node2_22;

        System.out.println(12-34);
        System.out.println(new Q26().isSubTree(root1, root2));

    }





}
