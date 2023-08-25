package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.DoubleNode;

import java.util.Iterator;

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
 * Item popLeft()            从左端删除一个元素
 * Item popRight()           从右端删除一个元素
 * -----------------------------------------------------
 * 编写一个使用双向链表实现这份API的Deque类。以及一个使用动态数据组调整实现这份API的ResizingArrayDeque类。
 */
public class Deque<Item> implements Iterable<Item> {

    private DoubleNode<Item> left;

    private DoubleNode<Item> right;

    private int N;

    public Deque() {
    }

    void pushLeft(Item item) {
        DoubleNode<Item> doubleNode = new DoubleNode<>(item);
        if (left == null) {
            right = doubleNode;
        } else {
            left.prev = doubleNode;
        }
        doubleNode.next = left;
        left = doubleNode;
        N++;
    }

    void pushRight(Item item) {
        DoubleNode<Item> doubleNode = new DoubleNode<>(item);
        if (right == null) {
            left = doubleNode;
        } else {
            right.next = doubleNode;
        }
        doubleNode.prev = right;
        right = doubleNode;
        N++;
    }

    Item popLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        final Item item = left.item;
        final DoubleNode<Item> next = left.next;
        if (next == null) {
            right = null;
        } else {
            next.prev = null;
        }
        left = next;
        N--;
        return item;
    }

    Item popRight() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        final Item item = right.item;
        final DoubleNode<Item> prev = right.prev;
        if (prev == null) {
            left = null;
        } else {
            prev.next = null;
        }
        right = prev;
        N--;
        return item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
//        return N == 0;
        return left == null;
    }

    @Override
    public String toString() {
        DoubleNode<Item> curr = left;
        String s = "";
        while (curr != null) {
            s += curr.item;
            s += "<->";
            curr = curr.next;
        }
        s += "null";
        return s;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private DoubleNode<Item> current = left;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            final Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
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
