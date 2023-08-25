package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 编写一个方法 delete()，接受一个 int 参数 k，删除链表的第 k 个元素（如果它存在的话）。
 */
public class Ex20<T> {

    Node<T> first;

    public Ex20(Node<T> first) {
        this.first = first;
    }

    public void delete(int k) {
        // deal with k <= 0, list is empty
        if (k <= 0 || first == null) {
            return;
        }
        // deal with first node
        if (k == 1) {
            first = first.next;
            return;
        }
        Node<T> current = first; // 0
        int i = 1;
        while (i < k - 1) {
            // k =3;
            // k - 1 = 2
            // 0 1
            // i = 1
            current = current.next; // 1
            i++;
        }
        Node<T> next = current.next;
        current.next = next.next;
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


        Ex20<String> ex = new Ex20<>(first);

        // 删除尾节点之前
        System.out.println("原链表：");
        ex.display();

        ex.delete(4);
        System.out.println("删除成功");

        System.out.println("新链表：");
        ex.display();
    }

}
