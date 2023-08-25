package io.github.kangjinghang.chapter1_3.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 双向队列与栈。用一个双向队列实现两个栈，保证每个栈操作只需要常数次的双向队列操作（请
 * 见练习 1.3.33）。
 */
public class Ex48<Item> {

    private Deque<Item> deque;

    private int NLeft = 0;

    private int NRight = 0;

    public Ex48() {
        deque = new Deque<>();
    }

    public boolean isEmptyLeft() {
        return NLeft == 0;
    }

    public int sizeLeft() {
        return NLeft;
    }

    public void pushLeft(Item item) {
        deque.pushLeft(item);
        NLeft++;
    }

    public Item popLeft() {
        if (NLeft == 0) return null;
        Item item = deque.popLeft();
        NLeft--;
        return item;
    }

    public int sizeRight() {
        return NRight;
    }

    public void pushRight(Item item) {
        deque.pushRight(item);
        NRight++;
    }

    public Item popRight() {
        if (NRight == 0) return null;
        Item item = deque.popRight();
        NRight--;
        return item;
    }

    public static void main(String[] args) {
        Ex48<String> s = new Ex48<>();
        s.pushLeft("1");
        s.pushLeft("2");
        s.pushLeft("3");
        s.pushRight("4");
        s.pushRight("5");
        s.pushRight("6");
        StdOut.println("Stack of Left size is:" + s.sizeLeft());
        StdOut.println("Stack of Right size is:" + s.sizeRight());
        //
        StdOut.println("Stack of Left element is:");
        for (int i = 0; i < 7; i++)
            StdOut.print(s.popLeft() + " ");
        //
        StdOut.println();
        StdOut.println("Stack of Right element is:");
        for (int i = 0; i < 7; i++)
            StdOut.print(s.popRight() + " ");
    }
}
