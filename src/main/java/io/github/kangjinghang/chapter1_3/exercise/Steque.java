package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

import java.util.Iterator;

/**
 * Steque。一个以栈为目标的队列（或称 steque），是一种支持 push、 pop 和 enqueue 操作的数
 * 据类型。为这种抽象数据类型定义一份 API 并给出一份基于链表的实现。
 *
 * <p>
 * push、 pop 都是对队列同一端的操作， enqueue 和 push 对应，但操作的是队列的另一端。
 */
public class Steque<T> implements Iterable<T> {

    private Node<T> first;

    private int N;

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = first;
        first = node;
        N++;
    }

    public T pop() {
        final T item = first.item;
        N--;
        first = first.next;
        return item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
//        return N == 0;
        return first == null;
    }

    public void enqueue(T item) {
        if (first == null) {
            first = new Node<>(item);
            N++;
            return;
        }
        Node<T> curr = first;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node<>(item);
        N++;
    }

    @Override
    public String toString() {
        Node<T> curr = first;
        String s = "";
        while (curr != null) {
            s += curr.item;
            s += "->";
            curr = curr.next;
        }
        s += "null";
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            final T item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque();
        steque.push(1);
        steque.enqueue(2);
        steque.push(3);
        steque.enqueue(4);

        System.out.println(steque);  // 输出: 3 -> 1 -> 2 -> 4 -> null

        System.out.println("Pop: " + steque.pop());  // 输出: Pop: 3
        System.out.println("Pop: " + steque.pop());  // 输出: Pop: 1

        System.out.println(steque);  // 输出: 2 -> 4 -> null
    }


}
