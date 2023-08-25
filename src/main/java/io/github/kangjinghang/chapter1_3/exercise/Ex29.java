package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

import java.util.Iterator;

/**
 * 用环形链表实现 Queue。环形链表也是一条链表，只是没有任何结点的链接为空，且只要链表非
 * 空则 last.next 的值为 first。只能使用一个 Node 类型的实例变量（ last）。
 */
public class Ex29<T> implements Iterable<T> {

    private Node<T> last;

    public void enqueue(T item) {
        final Node<T> node = new Node<>(item);
        if (last == null) {
            // 空链表
            node.next = node;
        } else {
            // 新节点接到首节点，组成环
            node.next = last.next;
            last.next = node;
        }
        last = node;
    }

    public T dequeue() {
        if (last == null) {
            return null;
        } else if (last.next == last) {
            // 只有1个节点
            final T item = last.item;
            last = null;
            return item;
        } else {
            // 有多个节点
            final T item = last.item;
            last.next = last.next.next;
            return item;
        }
    }

    public int size() {
        int size = 0;
        if (last == null) {
            return size;
        }
        Node<T> current = last.next;
        while (current != last) {
            size++;
            current = current.next;
        }
        return size + 1;
    }

    public boolean isEmpty() {
        return size() != 0;
    }

    public void display() {
        if (last == null) {
            return;
        }
        final Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            final T next = iterator.next();
            System.out.print(next + " -> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Ex29<Integer> queue = new Ex29<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(3);
        System.out.println(queue.size());
        queue.display();

        System.out.println("---------");
        System.out.println(queue.dequeue());

        System.out.println("---------");
        queue.forEach(System.out::println);

        System.out.println("---------");

    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

        private Node<T> current;

        public QueueIterator() {
            if (last != null) {
                current = last.next;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            final T result = current.item;
            if (current == last) {
                current = null;
            } else {
                current = current.next;
            }
            return result;
        }
    }

}
