package io.github.kangjinghang.chapter1_3;


import java.util.StringJoiner;

public class Node<T> {

    public T item;

    public Node<T> next;

    public Node(T item) {
        this.item = item;
    }

    public Node() {
    }

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                .add("item=" + item)
//                .add("next=" + next)
                .toString();
    }
}
