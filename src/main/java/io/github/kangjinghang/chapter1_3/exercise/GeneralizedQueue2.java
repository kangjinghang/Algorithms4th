package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

/**
 * 删除第 k 个元素。实现一个类并支持表 1.3.12 中的 API：
 * -----------------------------------------------------
 * public class GeneralizedQueue<Item>
 * -----------------------------------------------------
 * GeneralizedQueue() 创建一条空队列
 * boolean isEmpty() 队列是否为空
 * void insert(Item x) 添加一个元素
 * Item delete(int k) 删除并返回最早插入的第 k 个元素
 * -----------------------------------------------------
 * 首先用数组实现该数据类型，然后用链表实现该数据类型。 注意：我们在第 3 章中介绍的算法
 * 和数据结构可以保证 insert() 和 delete() 的实现所需的运行时间和和队列中的元素数量成对
 * 数关系——请见练习 3.5.27。
 */
public class GeneralizedQueue2<Item> {

    private Node<Item> first;

    private Node<Item> last;

    private int N;

    public GeneralizedQueue2() {
        N = 0;
    }

    public void insert(Item item) {
        final Node<Item> node = new Node<>(item);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        N++;
    }

    public Item delete(int k) {
        Node<Item> pre = null;
        Node<Item> curr = first;
        for (int i = 1; i < k; i++) {
            pre = curr;
            curr = curr.next;
        }
        if (pre == null) {
            // k = 1，curr = head
            if (curr.next == null) {
                first = last = null;
            } else {
                first = curr.next;

            }
        } else {
            pre.next = curr.next;
        }

        N--;
        return curr.item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public static void main(String[] args) {
        GeneralizedQueue2<Integer> generalizedQueue = new GeneralizedQueue2<>();
        generalizedQueue.insert(0);
        generalizedQueue.insert(1);
        generalizedQueue.insert(2);
        generalizedQueue.insert(3);
        generalizedQueue.insert(4);

        generalizedQueue.delete(3);
    }

}
