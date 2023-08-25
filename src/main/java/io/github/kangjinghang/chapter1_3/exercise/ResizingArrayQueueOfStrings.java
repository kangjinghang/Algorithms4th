package io.github.kangjinghang.chapter1_3.exercise;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 编写一个类 ResizingArrayQueueOfStrings，使用定长数组实现队列的抽象，然后扩展实现，
 * 使用调整数组的方法突破大小的限制。
 */
public class ResizingArrayQueueOfStrings implements Iterable<String> {

    private String[] a;

    private int N;

    public ResizingArrayQueueOfStrings(int cap) {
        a = new String[cap];
        N = 0;
    }

    void push(String s) {
        if (N == a.length) {
            // 2倍扩容
            resize(2 * a.length);
        }
        a[N++] = s;
    }

    String pop() {
        final String s = a[--N];
        // 检测条件是栈大小是否小于数组的四分之一。在数组长度被减半之后，它的状态约为半满
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return s;
    }

    int size() {
        return N;
    }

    boolean isEmpty() {
        return N == 0;
    }

    private void resize(int size) {
        a = Arrays.copyOf(a, size);
    }

    @Override
    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * 倒序
     */
    private class ReverseArrayIterator implements Iterator<String> {

        /**
         * 将 N 赋值给游标 i
         */
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public String next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings strings = new ResizingArrayQueueOfStrings(1);
        strings.push("one");
        strings.push("two");
        strings.push("three");
        while (!strings.isEmpty()) {
            System.out.println(strings.pop());
        }
    }

}
