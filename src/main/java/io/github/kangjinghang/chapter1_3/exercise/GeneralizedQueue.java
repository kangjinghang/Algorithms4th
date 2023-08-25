package io.github.kangjinghang.chapter1_3.exercise;

import java.util.Arrays;

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
public class GeneralizedQueue<Item> {

    private static final int INITIAL_CAPACITY = 1;

    private Item[] a;

    private int N;

    public GeneralizedQueue() {
        a = (Item[]) new Object[INITIAL_CAPACITY];
    }

    public void insert(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public Item delete(int k) {
        final Item item = a[k - 1];
        for (int i = k - 1; i < N; i++) {
            a[i] = a[i + 1];
        }
        N--;
        return item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        if (N >= 0) System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public static void main(String[] args) {
        GeneralizedQueue<Integer> generalizedQueue = new GeneralizedQueue<>();
        generalizedQueue.insert(0);
        generalizedQueue.insert(1);
        generalizedQueue.insert(2);
        generalizedQueue.insert(3);
        generalizedQueue.insert(4);

        generalizedQueue.delete(3);
        System.out.println(Arrays.toString(generalizedQueue.a));
    }

}
