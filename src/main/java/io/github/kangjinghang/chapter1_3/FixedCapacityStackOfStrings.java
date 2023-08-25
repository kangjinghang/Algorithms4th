package io.github.kangjinghang.chapter1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 一种表示容量固定的字符串栈的抽象数据类型
 */
public class FixedCapacityStackOfStrings {

    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    void push(String s) {
        a[N++] = s;
    }

    String pop() {
        return a[--N];
    }

    boolean isEmpty() {
        return N == 0;
    }

    boolean isFull() {
        return N == a.length;
    }

    int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
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
    }

}
