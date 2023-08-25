package io.github.kangjinghang.chapter1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    /**
     * 指向最早添加的结点的链接
     */
    private Node<Item> first;

    /**
     * 指向最近添加的结点的链接
     */
    private Node<Item> last;

    /**
     * 队列中的元素数量
     */
    private int N;

    public boolean isEmpty() {
        // 或： N == 0
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        // 向队尾添加元素
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        if (isEmpty()) {
            // 队列为空
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        // 从队头删除元素
        if (isEmpty()) {
            return null;
        }
        Item res = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return res;
    }

    @Override
    public String toString() {
        Node<Item> curr = first;
        String s = "";
        while (curr != null) {
            s += curr.item;
            s += "->";
            curr = curr.next;
        }
        return s;
    }

    public void catenation(Queue<Item> q) {
        if (isEmpty()) {
            first = q.first;
            last = q.last;
            N = q.size();
        } else if (!q.isEmpty()) {
            last.next = q.first;
            last = q.last;
            N += q.size();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            // 检测 current 是否为 null
            return current != null;
        }

        @Override
        public Item next() {
            if (current != null) {
                final Item result = current.item;
                current = current.next;
                return result;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Queue<String> s = new Queue<>();
        In in = new In("/Users/kangjinghang/workspace/github/Algorithms4th/src/main/resources/introcs-data/tobe.txt");
//        System.out.println(in.exists());
        // to be or not to - be - - that - - - is
        // "-" 用来出栈
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) {
                s.enqueue(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.dequeue() + " ");
            }
        }
        // to be or not to be (2 left on stack)
        StdOut.println("(" + s.size() + " left on stack)");
        System.out.println("--------------");
//        // 栈：to is
//        for (Object o : s) {
//            System.out.println(o);
//        }
    }

}
