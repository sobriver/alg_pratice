package com.hw.alg.list;

import javax.xml.soap.Node;

/**
 * @author hw
 * @date 2019/6/23 16:19
 * @desc 单链表
 */
public class NodeList {

    public SNode head; //头节点
    public SNode current; //当前指针指向的节点


    /**
     * 添加节点
     * @param data
     */
    public void add(int data){
        if(head == null){
            head = new SNode(data);
            current = head;
        } else {
            current.next = new SNode(data);
            current = current.next; //移动当前指针到下一个节点处
        }
    }


    /**
     * 单链表节点
     */
    static class SNode {
        int data;
        SNode next;
        public SNode(int data) {
            this.data = data;
        }
    }








}
