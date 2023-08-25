package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 编写一个方法 max()，接受一条链表的首结点作为参数，返回链表中键最大的节点的值。假设所
 * 有键均为正整数，如果链表为空则返回 0。
 * <p>
 * 用递归的方法解答上一道练习。
 */
public class Ex28 {

    Node<Integer> first;

    public Ex28(Node<Integer> first) {
        this.first = first;
    }

    public static int max(Node<Integer> head) {
        if (head == null) {
            return 0;
        }
        return Math.max(head.item, max(head.next));
    }

    public void display() {
        Node<Integer> current = first;
        while (current != null) {
            System.out.print(current.item + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node<Integer> first = new Node<>();
        Node<Integer> second = new Node<>();
        Node<Integer> third = new Node<>();
        Node<Integer> forth = new Node<>();
        Node<Integer> fifth = new Node<>();
        first.item = 1;
        first.next = second;
        second.item = 2;
        second.next = third;
        third.item = 3;
        third.next = forth;
        forth.item = 4;
        forth.next = fifth;
        fifth.item = 5;
        fifth.next = null;

        // second third first
        Ex28 ex = new Ex28(first);
        System.out.println("链表：");
        ex.display();
        System.out.println(max(first));

    }

}
