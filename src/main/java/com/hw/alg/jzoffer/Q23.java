package com.hw.alg.jzoffer;

/**
 * 如果一个链表中包含环,找出环的入口节点
 * 解析:
 * 1. 先求出环包括的节点个数k
 *      1.1 准备两个指针,一个一次走1步,一个走2步,若链表有环,则相遇时的节点必在环内,求出相遇的节点
 *      1.2 从该相遇的节点出发,沿着环走一圈,当再次回到该节点处的时候,就能统计出环的节点数量
 * 2. 准备两个指针p1,p2, p1先向前移动k步, 然后p1,p2同时向前移动,这样当k1,k2第一次相遇的时候就是入口节点
 * 此处解释如下: 假设p1,p2走了x步相遇,则p1,p2走的步数之差为k+x-x=k, 从链表的后面往前数的话,刚好是处于环的入口处
 */
public class Q23 {


    /**
     * 找出环的入口节点
     * @param head
     * @return
     */
    public static Node entryNode(Node head){
        if (head == null || head.next == null)
            return null;
        Node meetNode = meetNode(head);
        //此处表明该链表无环,直接返回
        if (meetNode == null)
            return null;
        //计算环的节点个数(此处需要注意while循环的终止条件)
        int sum = 1;
        Node tmp = meetNode.next;
        while (tmp != meetNode){
            sum++;
            tmp = tmp.next;
        }

        System.out.println("环中节点个数=" + sum);
        Node p1 = head;
        Node p2 = head;
        for (int i=0; i < sum; i++){
            p1 = p1.next;
        }

        while (p1 != null && p2 != null){
            if (p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }



    /**
     * 找出链表环中的一个节点
     * @param head
     * @return
     */
    public static Node meetNode(Node head){
        if (head == null)
            return null;
        Node p1 = head;
        Node p2 = head.next;
        if (p2 == null)
            return null;

        while (p1 != null && p2 != null){
            if (p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null){
                p2 = p2.next;
            }
        }
        return null;
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
        node5.next = node2;


        System.out.println(entryNode(node1).value);
    }
}
