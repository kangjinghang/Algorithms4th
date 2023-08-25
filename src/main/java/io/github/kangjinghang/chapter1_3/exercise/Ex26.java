package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 编写一个方法 remove()，接受一条链表和一个字符串 key 作为参数，删除链表中所有 item 域
 * 为 key 的结点
 */
public class Ex26<T> {

    Node<T> first;

    public Ex26(Node<T> first) {
        this.first = first;
    }

    public static void remove(Ex26<String> linkList, String key) {
        Node<String> current = linkList.first;
        while (current != null && current.next != null) {
            if (current.next.item.equals(key)) {
                current.next = current.next.next;
                // 这时，current 指针不移动，等待下次循环，继续检查新的 next 节点（因为 next.item 可能也是 key）
            } else {
                current = current.next;
            }
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
        forth.item = "second";
        forth.next = fifth;
        fifth.item = "second";
        fifth.next = null;

        // second third first
        Ex26<String> ex = new Ex26<>(first);
        remove(ex, "second");

        System.out.println("新链表：");
        ex.display();
    }

}
