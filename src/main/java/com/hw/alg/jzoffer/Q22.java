package com.hw.alg.jzoffer;

/**
 * 求链表倒数第k个节点,k从1开始计数
 * 解析:
 * 准备两个指针p1,p2,然后将p1向前移动k-1,再同时移动p1,p2,这样当p1达到链表尾结点时,p2指向的就是倒数第k个节点
 * 原因: 当p1,p2都开始移动时,他们之间的距离始终为k-1,当p1达到尾结点时,p2与尾结点之间的距离刚好为k-1,即倒数第k个节点(此处是从1开始,所以是k-1)
 */
public class Q22 {

    public static Node reverseNode(Node head, int k){
        if (head == null || k < 1)
            return null;
        Node p1 = head;
        Node p2 = head;

        //注意,此处需防止k的数值比链表总节点数大,这样在遍历的时候会出现空指针,所以需要遍历一遍,检验k值有效性
        for (int i=0; i < k-1; i++){
            if (p1 != null){
                p1 = p1.next;
            } else {
                return null;
            }
        }

        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }



    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(reverseNode(node1, 2).value);
    }
}
