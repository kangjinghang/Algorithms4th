package io.github.kangjinghang.chapter1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Bga，也是后进先出的顺序，但顺序在这里并不重要
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first;

    private int N;

    public boolean isEmpty() {
        // 或： N == 0
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

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
        Bag<String> s = new Bag<>();
        In in = new In("/Users/kangjinghang/workspace/github/Algorithms4th/src/main/resources/introcs-data/tobe.txt");
//        System.out.println(in.exists());
        // to be or not to - be - - that - - - is
        // "-" 用来出栈
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) {
                s.push(item);
            }
        }
        // to be not that or be (2 left on stack)
        StdOut.println("(" + s.size() + " left on stack)");
        System.out.println("--------------");
//        // 栈：to is
//        for (Object o : s) {
//            System.out.println(o);
//        }
    }

}
