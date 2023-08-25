package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 编写一个方法 insertAfter()，接受两个链表结点作为参数，将第二个结点插入链表并使之成
 * 为第一个结点的后续结点（如果两个参数为空则什么也不做）。
 */
public class Ex25<T> {

    Node<T> first;

    public Ex25(Node<T> first) {
        this.first = first;
    }

    public void insertAfter(Node<T> pre, Node<T> node) {
        if (pre == null || node == null) {
            return;
        }
        node.next = pre.next;
        pre.next = node;
    }

    public void display() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.item + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node<String> first = new Node<>();
        Node<String> second = new Node<>();
        Node<String> third = new Node<>();
        Node<String> forth = new Node<>();
        Node<String> fifth = new Node<>();
        first.item = "first";
        first.next = second;
        second.item = "second";
        second.next = third;
        third.item = "third";
        third.next = forth;
        forth.item = "forth";
        forth.next = fifth;
        fifth.item = "fifth";
        fifth.next = null;

        Node<String> sixth = new Node<>();
        sixth.item = "sixth";
        Ex25<String> ex = new Ex25<>(first);
        ex.insertAfter(third, sixth);

        System.out.println("新链表：");
        ex.display();
    }

}
