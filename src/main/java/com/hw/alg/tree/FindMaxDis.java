package com.hw.alg.tree;


/**
 * @author hw
 * @date 2019/8/13 21:14
 * @desc 找到一个二叉树中距离最远的两个节点的距离
 */
public class FindMaxDis {

    /**
     * 计算树的高度(此处的高度是指从根节点出发到达一个最远叶子节点的过程中经过的节点总个数)
     * 使用递归计算,每次计算左子树的高度和右子树的高度,然后比较两者中的较大值并且每比较一次就加一
     * @param root
     * @return
     */
     static int height(Node root){
        int deep = 0;
        if (root != null){ //递归调用的终点,此时表明该节点是叶子节点
            int left = height(root.left);
            int right = height(root.right);
            //关键: 比较左子树和右子树高度,取高度最大的,并且每比较一次高度加1
            deep = left >= right ? left+1 : right+1;
        }
        return deep;
    }

    /**
     * 求二叉树中节点的最大距离
     * 有三种情况:
     * 1. 两个叶子节点都出现在左树
     * 2. 两个叶子节点都在右树
     * 3. 一个在左树,一个在右树
     * 取这三种情况的最大值
     * @param root
     * @return
     */
    static int getMax(Node root){
        if (root == null)
            return 0;
        int lMax = getMax(root.left); //左子树的最大值(递归调用)
        int rMax = getMax(root.right); //右子树的最大值(递归调用)

        int lh = 0;//左子树的高度
        int rh = 0;//右子树的高度
        if (root.left != null){
            lh = height(root.left);
        }
        if (root.right != null){
            rh = height(root.right);
        }
        //lmax, rmax, lh+rh比较最大值
        return Math.max(Math.max(lMax, rMax), lh + rh);
    }


    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node node7 = new Node(7, null, null);//root
        Node node5 = new Node(5, null, null);
        Node node2 = new Node(2, null, null);
        Node node9 = new Node(9, null, null);
        Node node11 = new Node(11, null, null);
        Node node8 = new Node(8, null, null);
        Node node20 = new Node(20, null, null);
        Node node18 = new Node(18, null, null);
        Node node21 = new Node(21, null, null);

        node7.left = node5;
        node7.right = node11;
        node5.left = node2;
        node5.right = node9;
        node11.left = node8;
        node11.right = node20;
        node20.left = node18;
        node18.right = node21;

        System.out.println(getMax(node7));
    }

}

