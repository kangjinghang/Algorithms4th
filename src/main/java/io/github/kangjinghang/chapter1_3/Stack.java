package io.github.kangjinghang.chapter1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;

    private int N;

    public boolean isEmpty() {
        // 或： N == 0
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        // 向栈顶添加元素
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        // 从栈顶删除元素
        Item res = first.item;
        first = first.next;
        N--;
        return res;
    }

    public Item peek() {
        return first.item;
    }

    /**
     * 将 this 从 first 开始依次挂到 original 末尾
     */
    public void catenation(Stack<Item> original) {
        Node<Item> newCopy;
        if (!original.isEmpty()) {
            Node<Item> current = original.first;
            while (current.next != null) {
                current = current.next;
            }
            // current 是 original 最后一个节点
            current.next = first;
            first = original.first;
            N += original.size();
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

    @Override
    public String toString() {
        Node curr = first;
        String s = "";
        while (curr != null) {
            s += curr.item;
            s += "->";
            curr = curr.next;
        }
        return s;
    }

    /**
     * 由于栈的迭代器是逆向的迭代器，实现时需要注意方向问题。
     */
    public static <T> Stack<T> copy(Stack<T> s) {
        Iterator<T> it = s.iterator();
        // 因为逆向，所以要复制两次
        Stack<T> result = new Stack<>();
        Stack<T> temp = new Stack<>();
        while (it.hasNext()) {
            temp.push(it.next());
        }
        it = temp.iterator();
        while (it.hasNext()) {
            result.push(it.next());
        }
        return result;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
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
//        // 栈：to is
        for (Object o : s) {
            System.out.println(o);
        }
    }

}
