package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 编写一个方法 removeAfter()，接受一个链表结点作为参数并删除该结点的后续结点（如果参
 * 数结点或参数结点的后续结点为空则什么也不做）。
 */
public class Ex24<T> {

    Node<T> first;

    public Ex24(Node<T> first) {
        this.first = first;
    }

    public void removeAfter(Node<T> n) {
        if (n == null || n.next == null) {
            return;
        }
        Node<T> current = first;
        while (current.next != null) {
            if (current.next.equals(n)) {
                current.next = null;
                return;
            }
            current = current.next;
        }
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


        Ex24<String> ex = new Ex24<>(first);
        ex.removeAfter(third);

        System.out.println("新链表：");
        ex.display();
    }

}
