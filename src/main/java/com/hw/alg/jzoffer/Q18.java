package com.hw.alg.jzoffer;

public class Q18 {

    /**
     * 已知单链表的头结点和待删除的某个节点,删除该节点,要求时间复杂度是O(1)
     * 思路: 将删除节点的下一个节点复制到待删除的节点,然后删除下一个节点即可
     */
    public void deleteNode(ListNode head, ListNode node){
        if (head == null || node == null){
            return;
        }
        //链表只有一个节点
        if (head == node){
            head = null;
            node = null;
        }

        //要删除的链表节点是尾结点,需要遍历链表
        if (node.next == null){
            ListNode p = head;
            while ( p != node){
                p = p.next;
            }
            p.next = null;
            node = null;
        } else {
            //待删除的节点是普通节点,替换即可
            ListNode next = node.next;
            node.value = next.value;
            node.next = next.next;
        }
    }

    /**
     * 删除一个排好序的链表中的重复节点
     */
    public void deleteDuplicate(ListNode head){
        if (head == null || head.next == null)
            return;
        ListNode currentNode = head.next;//当前节点
        ListNode preNode = head; //当前节点的前一个节点
        while (currentNode != null){
            if (currentNode.value == preNode.value){

            }

        }


    }



    public void print(ListNode head){
        if (head == null)
            return;
        System.out.println(head.value);
        ListNode p = head.next;
        while (p != null){
            System.out.println(p.value);
            p = p.next;
        }
    }

    static class ListNode {

        public ListNode(int value) {
            this.value = value;
        }

        int value;
        ListNode next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Q18 q18 = new Q18();

        q18.deleteNode(node1, node5);
        q18.print(node1);


    }

}
