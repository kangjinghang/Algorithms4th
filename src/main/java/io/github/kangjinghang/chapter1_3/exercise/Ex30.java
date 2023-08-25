package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 编写一个函数，接受一条链表的首结点作为参数，（破坏性地）将链表反转并返回结果链表的
 * 首结点。
 */
public class Ex30<T> {

    Node<T> first;

    public Ex30(Node<T> first) {
        this.first = first;
    }

    public void reverseWithRecursion() {
        first = reverse(first);
    }

    private Node<T> reverse(Node<T> head) {
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null) {
            Node<T> next = current.next;
            // 关键，反转指针方向，current -> next 变为 current -> prev
            current.next = prev;
            // 移动指针 prev 和 current
            prev = current;
            current = next;
        }
        return prev;
    }

    private Node<T> reverseWithRecursion(Node<T> head) {
        // 1 -> 2 -> 3 -> 4 -> null
        if (head == null || head.next == null) {
            // Base case: If the current node is null or the last node, return it
            return head;
        }
        // 先递归颠倒最后 N-1 个结点
        final Node<T> newHead = reverseWithRecursion(head.next);
        // 将原链表中的首结点插入到结果链表的末端
        // 此时，newHead 是 4 -> 3 -> 2 -> null，只要将 1 挂到 2 的后面即可
        head.next.next = head;
        head.next = null;
        return newHead;
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
        Ex30<Integer> ex = new Ex30<>(first);
        ex.reverseWithRecursion();

        System.out.println("新链表：");
        ex.display();
    }

}
