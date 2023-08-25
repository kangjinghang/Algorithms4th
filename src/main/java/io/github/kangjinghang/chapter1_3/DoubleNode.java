package io.github.kangjinghang.chapter1_3;


public class DoubleNode<T> {

    public T item;

    public DoubleNode<T> prev;

    public DoubleNode<T> next;


    public DoubleNode() {
    }

    public DoubleNode(T item) {
        this.item = item;
    }

    public DoubleNode(T item, DoubleNode<T> prev, DoubleNode<T> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

}
