package com.hw.alg.base;

/**
 * 链表工具类
 */
public class ListUtils {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        add(node1, node1);
        add(node1, node2);
        add(node1, node3);

        printAll(node1);



    }

    /**
     * 往单链表尾部追加元素
     * @param head 链表头
     * @param node 追加的链表节点
     */
    public static void add(Node head, Node node){
        if (head == node)
            return;
        Node tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * 从头开始打印链表所有元素
     * @param head 链表头
     */
    public  static void  printAll(Node head){
        if (head == null)
            return;
        Node current = head;
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }



}
