package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 编写一个方法 find()，接受一条链表和一个字符串 key 作为参数。如果链表中的某个结点的
 * item 域的值为 key，则方法返回 true，否则返回 false。
 */
public class Ex21<T> {

    Node<T> first;

    public Ex21(Node<T> first) {
        this.first = first;
    }

    public static <E> boolean find(Ex21<E> linkList, String key) {
        Node<E> current = linkList.first;
        if (current == null) {
            return false;
        }
        while (current != null) {
            if (current.item.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
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


        Ex21<String> ex = new Ex21<>(first);

        System.out.println(find(ex, "third"));
        System.out.println(find(ex, "sixth"));

    }

}
