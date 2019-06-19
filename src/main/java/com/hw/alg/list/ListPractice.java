package com.hw.alg.list;

/**
 * @author hw
 * @date 2019/5/31 23:05
 * @desc
 */
public class ListPractice {

    public static void main(String[] args) {
        //环形单链表，A1-B1-C1-D1-A1
        SingleNode<String> nodeA1 = new SingleNode<>("A", null);
        SingleNode<String> nodeB1 = new SingleNode<>("B", null);
        SingleNode<String> nodeC1 = new SingleNode<>("C", null);
        SingleNode<String> nodeD1 = new SingleNode<>("D", null);
        nodeA1.next = nodeB1;
        nodeB1.next = nodeC1;
        nodeC1.next = nodeD1;
        nodeD1.next = nodeA1;
        System.out.println(isLoop(nodeA1));
        
        //非环形单链表,A2-B2-C2-D2
        SingleNode<String> nodeA2 = new SingleNode<>("A", null);
        SingleNode<String> nodeB2 = new SingleNode<>("B", null);
        SingleNode<String> nodeC2 = new SingleNode<>("C", null);
        SingleNode<String> nodeD2 = new SingleNode<>("D", null);
        nodeA2.next = nodeB2;
        nodeB2.next = nodeC2;
        nodeC2.next = nodeD2;
        System.out.println(isLoop(nodeA2));
        
    }




    /**
     * 判断单链表是否有环
     * 采用快慢指针，一个指针移动1，一个指针移动2，若链表有环，则一定会出现两个指针指向的节点是同一个
     * 该算法空间复杂度O(1),时间复杂度O(n)
     */
    static boolean isLoop(SingleNode<String> head){
        SingleNode<String> slowPointer,fastPointer;
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
}
