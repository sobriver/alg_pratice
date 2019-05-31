package com.hw.alg.list;

/**
 * @author hw
 * @date 2019/5/31 10:57
 * @desc 单链表节点
 */
public class SingleNode<T> {
    T data;
    SingleNode<T> next;

    public SingleNode(T data, SingleNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
