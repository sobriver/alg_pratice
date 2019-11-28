package com.hw.jzoffer;


import com.hw.base.ListUtils;
import com.hw.base.Node;

public class Q25 {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        ListUtils.add(head1, head1);
        ListUtils.add(head1, node2);
        ListUtils.add(head1, node3);


        Node head2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(10);
        ListUtils.add(head2, head2);
        ListUtils.add(head2, node4);
        ListUtils.add(head2, node5);

        ListUtils.printAll(merge(head1, head2));

    }


    /**
     * 合并两个递增的单链表为一个递增的单链表,返回合并后链表的头
     * 解析: 定义merge(head1, head2)函数表示返回合并链表1和链表2之后的链表的头,其中head1,head2分别为链表1和链表2的头节点
     * 现在分析递归的三个条件:
     * 1. 等价关系: 没有一般意义上的等价关系式,而是根据条件进行判断, 不好描述,可分析具体案例
     * 2. 退出条件: 当两个链表其中的某个达到尾部
     * 3. 递归函数: 见函数定义
     */
    public static Node merge(Node head1, Node head2){
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node head = null;
        if (head1.value < head2.value){
            head = head1;
            head.next = merge(head1.next, head2);
        } else {
            head = head2;
            head.next = merge(head1, head2.next);
        }

        return head;


    }




}
