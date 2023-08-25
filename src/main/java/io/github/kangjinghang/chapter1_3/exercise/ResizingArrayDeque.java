package io.github.kangjinghang.chapter1_3.exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Deque。一个双向队列（或者称为 deque）和栈或队列类似，但它同时支持在两端添加或删除元素。
 * Deque 能够存储一组元素并支持表 1.3.9 中的 API：
 * -----------------------------------------------------
 * public class Deque<Item> implements Iterable<Item>
 * -----------------------------------------------------
 * Deque()	             创建空双向队列
 * boolean isEmpty()            双向队列是否为空
 * int size()               双向队列中元素的数量
 * void pushLeft(Item item)  向左端添加一个新元素
 * void pushRight(Item item) 向右端添加一个新元素
 * Item popLeft()            从左羰删除一个元素
 * Item popRight()           从右羰删除一个元素
 * -----------------------------------------------------
 * 编写一个使用双向链表实现这份API的Deque类。以及一个使用动态数据组调整实现这份API的ResizingArrayDeque类。
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {

    private static final int INITIAL_CAPACITY = 8;

    private Item[] a;

    /**
     * 从右向左的指针
     * <--
     */
    private int front;

    /**
     * 从左向右的指针
     * -->
     */
    private int rear;

    public ResizingArrayDeque() {
        a = (Item[]) new Object[INITIAL_CAPACITY];
        front = 0;
        rear = 0;
    }

    void pushLeft(Item item) {
        // 向左移动
        front = (front - 1 + a.length) % a.length;
        if (front == rear) {
            resize(2 * a.length);
        }
        a[front] = item;
    }

    void pushRight(Item item) {
        // 向右移动
        rear = (rear + 1) % a.length;
        if (rear == front) {
            resize(2 * a.length);
        }
        a[rear] = item;
    }

    Item popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = a[front];
        a[front] = null;
        // 向右移动一次
        front = (front + 1) % a.length;
        if (a.length / 4 >= (rear - front + 1)) {
            resize(a.length / 2);
        }
        return item;
    }

    Item popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = a[rear];
        a[rear] = null;
        // 向左移动一次
        rear = (rear - 1 + a.length) % a.length;
        if (a.length / 4 >= (rear - front + 1)) {
            resize(a.length / 2);
        }
        return item;
    }

    void resize(int capacity) {
        Item[] newArr = (Item[]) new Object[capacity];
        int index = 0;
        for (int i = front; front != rear; i = (i + 1) % a.length) {
            newArr[index++] = a[i];
        }
        a = newArr;
        front = 0;
        rear = index;
    }

    int size() {
        return rear - front;
    }

    boolean isEmpty() {
        return front == rear;
    }


    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private int current = front;

        @Override
        public boolean hasNext() {
            return current != rear;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            Item item = a[current];
            do {
                current = (current + 1) % a.length;
            } while (a[current] == null);
            return item;
        }
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
        deque.pushRight(1);
        deque.pushLeft(2);
        deque.pushRight(3);
        deque.pushLeft(4);

        System.out.println("Deque is empty: " + deque.isEmpty());  // 输出: Deque is empty: false

        for (int value : deque) {
            System.out.print(value + " ");  // 输出: 4 2 1 3
        }
        System.out.println();

        System.out.println("Pop left: " + deque.popLeft());  // 输出: Pop left: 4
        System.out.println("Pop right: " + deque.popRight());  // 输出: Pop right: 3

        System.out.println("Deque is empty: " + deque.isEmpty());  // 输出: Deque is empty: false

        for (int value : deque) {
            System.out.print(value + " ");  // 输出: 2 1
        }
        System.out.println();
    }

}
