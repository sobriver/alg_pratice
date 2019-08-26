package com.hw.alg.other;

/**
 * @author hw
 * @date 2019/7/24 9:32
 * @desc 队列和栈的实现
 */
public class QueueStatck {

    public static void main(String[] args) throws Exception{
        Node node1 = new Node(8);
        Node node2 = new Node(7);
        Node node3 = new Node(6);
        Node node4 = new Node(5);

        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.add(node1);
        linkedQueue.add(node2);
        linkedQueue.add(node3);
        linkedQueue.add(node4);

        linkedQueue.poll();
        linkedQueue.print();
    }



    //链表节点
    static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 队列:先进先出
     * 用链表实现,需要维护头尾两个指针,其中头指针用来出队,尾指针用来入队
     * (用数组实现的话,因为需要频繁操作数组的头部元素和尾部元素,效率低下)
     */
    static class LinkedQueue {

        Node head; //队列头
        Node tail; //队列尾
        int size ;

        public LinkedQueue() {
            head = tail = null;
            size = 0;
        }

        //入队,往链表尾部插入元素
        void add(Node node){
            if (size == 0){ //需要非空判断,否则第一次无法插入
                tail = head = node;
                size++;
                return;
            }
            tail.next = node;
            tail = node;
            size++;
        }

        //出队,将链表的头部删除
        void poll() throws Exception {
            if (size == 0){
                throw new Exception("队列为空");
            }
            head = head.next;// 将链表的头元素指针指向其下一个节点
            size--;
        }

        //打印队列,从头部开始打印
        void print(){
            if (size == 0){
                return;
            }
            System.out.println(head.value);
            Node next = head.next;
            while (next != null){
                System.out.println(next.value);
                next = next.next;
            }

        }
    }


    /**
     * 栈: 后进先出
     * 用数组来实现
     */
    static class Stack {

        int[] data;
        int size;

        public Stack() {
            data = new int[]{};
            size = 0;
        }

        //入栈,往数组尾部插入元素
        void add(int node){
            data[size] = node;
            size++;
        }

        //出栈,删除数组尾部元素
        void pop(){
            if (size == 0){
                return;
            }

        }



    }



}
