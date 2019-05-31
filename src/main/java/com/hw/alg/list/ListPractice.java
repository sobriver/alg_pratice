package com.hw.alg.list;

/**
 * @author hw
 * @date 2019/5/31 23:05
 * @desc
 */
public class ListPractice {

    public static void main(String[] args) {
        //1.测试isLoop方法
        //构造单链表
        SingleNode<String> nodeA = new SingleNode<>("A", null);
        SingleNode<String> nodeB = new SingleNode<>("B", null);
        SingleNode<String> nodeC = new SingleNode<>("C", null);
        SingleNode<String> nodeD = new SingleNode<>("D", null);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeB; //环
        System.out.println(isLoop(nodeA));
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
