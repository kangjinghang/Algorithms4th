package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 前移编码。从标准输入读取一串字符，使用链表保存这些字符并清除重复字符。当你读取了一
 * 个从未见过的字符时，将它插入表头。当你读取了一个重复的字符时，将它从链表中删去并再
 * 次插入表头。将你的程序命名为 MoveToFront：它实现了著名的前移编码策略，这种策略假设最
 * 近访问过的元素很可能会再次访问，因此可以用于缓存、数据压缩等许多场景。
 */
public class MoveToFront {

    private Node<Character> first;

    private int N;

    public void enqueue(Character c) {
        Node<Character> current = first;
        Node<Character> pre = null;
        while (current != null) {
            if (current.item.equals(c)) {
                break;
            }
            pre = current;
            current = current.next;
        }
        if (current != null) {
            // 重复字符
            if (pre != null) {
                pre.next = current.next;
            } else {
                // current = head
                first = current.next;
            }
        }
        insertToFirst(c);
    }

    private void insertToFirst(Character c) {
        Node<Character> node = new Node<>(c);
        node.next = first;
        first = node;
        N++;
    }

    /**
     * 先无脑入到表头，然后向后检查，把重复的节点移除
     */
    private void enqueue2(Character c) {
        Node<Character> node = new Node<>(c);
        node.next = first;
        first = node;
        N++;

        Node<Character> current = first;
        while (current.next != null) { // 一直检查到倒数第二个节点
            if (current.next.item.equals(c)) {
                final Node<Character> repeated = current.next;
                current.next = repeated.next;
                repeated.next = null;
                N--;
                break;
            }
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return first != null;
    }

    public int size() {
        return N;
    }

    public void display() {
        Node<Character> current = first;
        while (current != null) {
            System.out.print(current.item + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // d -> l -> r -> o -> w -> e -> h -> null
        String s = "helloworld";
        MoveToFront moveToFront = new MoveToFront();
        for (char c : s.toCharArray()) {
//            moveToFront.enqueue(c);
            moveToFront.enqueue2(c);
        }
        moveToFront.display();
    }

}
