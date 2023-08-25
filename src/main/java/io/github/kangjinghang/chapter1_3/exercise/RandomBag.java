package io.github.kangjinghang.chapter1_3.exercise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * 随机背包。 随机背包能够存储一组元素并支持表 1.3.10 中的 API：
 * -----------------------------------------------------
 * public class RandomBag<Item> implements Iterable<Item>
 * -----------------------------------------------------
 * RandomBag()//创建一个空随机背包
 * boolean isEmpty()//背包是否为空
 * int size()//背包中的元素数量
 * void add(Item item)//添加一个元素
 * -----------------------------------------------------
 * 编写一个 RandomBag 类来实现这份 API。请注意，除了形容词随机之外，这份 API 和 Bag 的 API
 * 是相同的，这意味着迭代应该随机访问背包中的所有元素（对于每次迭代，所有的 N! 种排列出
 * 现的可能性均相同）。 提示：用数组保存所有元素并在迭代器的构造函数中随机打乱它们的顺序。
 */
public class RandomBag<Item> implements Iterable<Item> {

    private static final int INITIAL_CAPACITY = 1;

    private Item[] a;

    private int N;

    public RandomBag() {
        a = (Item[]) new Object[INITIAL_CAPACITY];
    }

    public void add(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
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

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {

        /**
         * 每个元素的值是[0,N-1]，即 a 的下标的随机值
         */
        private final int[] seq = new int[N];

        private int index = 0;

        public RandomBagIterator() {
            for (int i = 0; i < seq.length; i++) {
                seq[i] = i;
            }
            // 随机：洗牌算法
//            StdRandom.shuffle(seq);
            shuffle(seq);
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

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);
        randomBag.add(4);

        for (Integer i : randomBag) {
            System.out.println(i);
        }
    }


}
