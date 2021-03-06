package com.hw.alg.list;
import java.util.List;
import com.hw.alg.list.NodeList.SNode;

/**
 * @author hw
 * @date 2019/5/31 23:05
 * @desc
 */
public class ListPractice {

    public static void main(String[] args) {

        SNode nodeA = new SNode(1);
        SNode nodeB = new SNode(2);
        SNode nodeC = new SNode(3);
        nodeA.next = nodeB;
        nodeB.next = nodeC;

        SNode head = reverse1(nodeA);
        print(head);

    }



    /**
     * 打印链表
     * @param head 链表头
     */
    static void  print(SNode head){
        if (head == null)
            return;
        SNode current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }


    /**
     * 判断单链表是否有环
     * 采用快慢指针，一个指针移动1，一个指针移动2，若链表有环，则一定会出现两个指针指向的节点是同一个
     * 该算法空间复杂度O(1),时间复杂度O(n)
     * @param head 链表头
     */
    static boolean isLoop(SNode head){
        SNode slowPointer,fastPointer;
        slowPointer = fastPointer = head;

        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }

    /**
     * 得到单链表中间的节点，注意若链表长度为偶数，则中间节点是n/2+1
     * 思路：依然是采用快慢两个指针，一个每次移动1，一个每次一定2，当快的那个指针达到链表尾部的时候，慢的那个指针此时刚好指向中间节点
     * @param head 链表头
     */
    static SNode fingMiddleNode(SNode head){
        if(head == null)
            return null;
        SNode slow = head;
        SNode fast = head;
        //注意此处需要同时判断快指针节点和下一节点都不为null,否则会出现空指针
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 将两个已经排好序的单链表合并成一个有序的单链表，如 1-2-3-4和3-4-5-6合并后变成1-2-3-3-4-4-5-6
     * 思路： 两个输入链表1和2以及一个新链表3，以及三个指针，分别指向1,2,3的头，其中3的指针对应的节点为1和2中较小的节点。
     *       将1和2中的较小者拷贝到3中的下一个位置，同时将相关的计数器往前推进一步。
     *       当1和2两个指针有一个为空的时候，表示该链表已经遍历完成，此时直接将另外一个剩余部分拷贝到3中即可
     *
     * @param list1 第一个单链表
     * @param list2 第二个单链表
     * @return head 结果list的头节点
     */
    static SNode merge(NodeList list1, NodeList list2){
        SNode head1 = list1.head;
        SNode head2 = list2.head;
        if (head1 == null && head2 == null) {  //如果两个链表都为空
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        SNode head; //新链表的头结点
        SNode current;  //current结点指向新链表

        // 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
        if (head1.data < head2.data) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;  //新链表中，current指针的下一个结点对应较小的那个数据
                current = current.next; //current指针下移
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }

        //合并剩余的元素
        if (head2 == null) { //说明链表2遍历完了，是空的
            current.next = head1;
        }

        if (head1 == null) { //说明链表1遍历完了，是空的
            current.next = head2;
        }

        return head;
    }


    /**
     * 反转链表,返回反转后链表的头
     * 解析: 因为要反转链表,所以需要知道当前结点的前一个节点,但因为是单链表,所以无法直接获得.
     * 可以先将当前结点的前一个结点缓存起来再使用
     * @param head
     * @return
     */
    static SNode reverse1(SNode head){
        if (head == null)
            return null;

        //注意初始的设置
        SNode pre = null;//当前节点的上一节点
        SNode current = head; //当前节点
        SNode reverseHead = null; //反转后的链表头结点

        while (current != null){
            SNode next = current.next;
            //反转后链表的头结点一定是反转之前链表的尾结点
            if (next == null)
                reverseHead = current;

            //此处需要将当前结点指向的前一个结点和后一个结点交换位置
            current.next = pre;
            pre = current;

            //继续遍历下一个结点
            current = next;
        }
        return reverseHead;
    }


    /**
     * 题目:判断两个链表是否相交
     * 思路: 需要考虑链表是否有环的情况
     * (1) 当两个链表都没有环时,判断两个链表的尾部元素是否相同,若相同,则相交,思路
     * (2) 当两个链表都有环时,若相交的话.交点要么在环上,要么在环外
     */
    static boolean isJoin(SNode node1, SNode node2){
        return false;
    }




}
