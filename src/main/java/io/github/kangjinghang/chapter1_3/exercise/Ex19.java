package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 给出一段代码，删除链表的尾结点，其中链表的首结点为 first。
 */
public class Ex19<T> {

    private Node<T> first;

    public Ex19(Node<T> first) {
        this.first = first;
    }

    public void deleteTail() {
        Node<T> current = first;
        if (current == null) {
            return;
        }
        if (current.next == null) {
            first = null;
            return;
        }
//        while (next.next != null) {
//            current = next;
//            next = current.next;
//        }
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
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

        // 删除尾节点之前
        System.out.println("原链表：");
        Ex19 ex = new Ex19(first);
        ex.display();

        // 删除最后一个元素
        ex.deleteTail();
        System.out.println("删除成功");

        System.out.println("新链表：");
        ex.display();
    }

}
