package io.github.kangjinghang.chapter1_3.exercise;

import java.util.Iterator;

/**
 * 环形缓冲区。环形缓冲区，又称为环形队列，是一种定长为 N 的先进先出的数据结构。它在进
 * 程间的异步数据传输或记录日志文件时十分有用。当缓冲区为空时，消费者会在数据存入缓冲
 * 区前等待；当缓冲区满时，生产者会等待将数据存入缓冲区。为 RingBuffer设计一份 API 并用（回
 * 环）数组将其实现。
 * <p>
 * first 指向队首，last 指向队尾，并配合 N 计数。
 * 或者，如果 first 指向队首，last 指向队尾，当 first 和 last 相等时，无法判断队列是空还是满，所以把 last 指向队尾的下一个位置来区分队列的空和满。
 */
public class RingBuffer<Item> implements Iterable<Item> {

    private final Item[] a;

    private int N;

    /**
     * 队首
     */
    private int first;

    /**
     * 下一个要入队的位置，队尾+1
     */
    private int last;

    public RingBuffer(int capacity) {
        a = (Item[]) new Object[capacity];
        N = 0;
        last = 0;
        first = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (isFull()) {
            System.err.println("The queue is full");
            return;
        }
        a[last] = item;
        last = (last + 1) % a.length;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            System.err.println("The queue is empty");
            return null;
        }
        Item item = a[first];
        a[first] = null;
        first = (first + 1) % a.length;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private int cnt;

        private int current = first;

        public boolean hasNext() {
            return cnt < N;
        }

        public Item next() {
            Item item = a[current];
            current = (current + 1) % a.length;
            cnt++;
            return item;
        }
    }

    public static void main(String[] args) {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        for (int i = 0; i < 3; i++) {
            ringBuffer.enqueue(i);
        }
        while (ringBuffer.size() > 1) {
            System.out.println(ringBuffer.dequeue());
        }
        System.out.println("queue size:" + ringBuffer.size());
        ringBuffer.enqueue(3);
        ringBuffer.enqueue(4);
        ringBuffer.forEach(System.out::println);
    }


}
