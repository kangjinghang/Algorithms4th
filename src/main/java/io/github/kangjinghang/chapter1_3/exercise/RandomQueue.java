package io.github.kangjinghang.chapter1_3.exercise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * 随机队列。 随机队列能够存储一组元素并支持表 1.3.11 中的 API：
 * -----------------------------------------------------
 * public class RandomQueue<Item>
 * -----------------------------------------------------
 * RandomQueue() 创建一条空的随机队列
 * boolean isEmpty() 队列是否为空
 * void enqueue(Item item) 添加一个元素
 * Item dequeue() 删除并随机返回一个元素（取样且不放回）
 * Item sample() 随机返回一个元素但不删除它（取样且放回）
 * -----------------------------------------------------
 * 编写一个 RandomQueue 类来实现这份 API。 提示：使用（能够动态调整大小的）数组表示
 * 数据。删除一个元素时，随机交换某个元素（索引在 0 和 N-1 之间）和末位元素（索引为
 * N-1）的位置，然后像 ResizingArrayStack 一样删除并返回末位元素。编写一个用例，使用
 * RandomQueue<Card> 在桥牌中发牌（每人 13 张）。
 */
public class RandomQueue<Item> implements Iterable<Item> {

    private static final int INITIAL_CAPACITY = 1;

    private Item[] a;

    private int N;

    public RandomQueue() {
        a = (Item[]) new Object[INITIAL_CAPACITY];
    }

    public void enqueue(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item dequeue() {
        int index = StdRandom.uniformInt(N);
        Item temp = a[index];
        a[index] = a[--N];
//        a[N - 1] = temp;
//        final Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return temp;
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
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        randomQueue.enqueue(5);

//        while (!randomQueue.isEmpty()) {
//            System.out.println(randomQueue.dequeue());
//        }
        randomQueue.forEach(System.out::println);

    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // between i and N-1
            // 选择 i 到 N-1 之间的随机整数 r
            int r = StdRandom.uniformInt(i, N);
            // 而不能选择 i 到 N-1 之间的随机整数，这样的结果并非均匀地分布在 N! 种可能性之间
//            int r = StdRandom.uniformInt(N);
            // a[i] 与 a[r] 互换，打乱
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    private class RandomQueueIterator implements Iterator<Item> {

        private final int[] seq;

        private int index;

        public RandomQueueIterator() {
            seq = new int[N];
            for (int i = 0; i < N; i++) {
                seq[i] = i;
            }
            shuffle(seq);
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < N;
        }

        @Override
        public Item next() {
            return a[seq[index++]];
        }
    }

}
