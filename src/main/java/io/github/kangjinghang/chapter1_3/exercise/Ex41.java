package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;
import io.github.kangjinghang.chapter1_3.Queue;

import java.util.Iterator;

/**
 * 复制队列。编写一个新的构造函数，使以下代码
 * Queue<Item> r = new Queue<Item>(q);
 * 得到的 r 指向队列 q 的一个新的独立的副本。可以对 q 或 r 进行任意入列或出列操作但它们不
 * 会相互影响。 提示：从 q 中取出所有元素再将它们插入 q 和 r。
 */
public class Ex41<Item> implements Iterable<Item> {

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

    public Ex41(Queue<Item> queue) {
        final int size = queue.size();
        for (int i = 0; i < size; i++) {
            enqueue(queue.dequeue());
        }
    }

    public boolean isEmpty() {
        // 或： N == 0
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        // 向队尾添加元素
        Node oldLast = last;
        last = new Node();
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
        Node curr = first;
        String s = "";
        while (curr != null) {
            s += curr.item;
            s += "->";
            curr = curr.next;
        }
        return s;
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

}
