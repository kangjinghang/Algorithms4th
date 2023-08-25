package io.github.kangjinghang.chapter1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;

    /**
     * 栈的深度，也是元素数量，也是下一个要入栈元素的位置
     */
    private int N;

    public ResizingArrayStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    void push(Item s) {
        // 入栈
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = s;
    }

    Item pop() {
        final Item item = a[--N];
        // 避免元素游离
        a[N] = null;
        // 检测条件是栈大小是否小于数组的四分之一。在数组长度被减半之后，它的状态约为半满
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return N;
    }

    void resize(int max) {
        // 将大小为 N < = max 的栈移动到一个新的大小为 max 的数组中
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(a, 0, temp, 0, N);
//        System.out.println("resize from " + a.length +" to " + max);
        a = temp;
    }

    public static void main(String[] args) {
        ResizingArrayStack s = new ResizingArrayStack(2);
        In in = new In("/Users/kangjinghang/workspace/github/Algorithms4th/src/main/resources/introcs-data/tobe.txt");
//        System.out.println(in.exists());
        // to be or not to - be - - that - - - is
        // "-" 用来出栈
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        // to be not that or be (2 left on stack)
        StdOut.println("(" + s.size() + " left on stack)");
        System.out.println("--------------");
        // 栈：to is
        for (Object o : s) {
            System.out.println(o);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        // 将游标设置到 N 的位置
        int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            // 向前推动游标
            return a[--i];
        }
    }


}
