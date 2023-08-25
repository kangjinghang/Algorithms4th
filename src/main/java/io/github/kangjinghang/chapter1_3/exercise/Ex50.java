package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Node;

import java.util.Iterator;

/**
 * 快速出错的迭代器。 修改 Stack 的迭代器代码，确保一旦用例在迭代器中（通过 push()
 * 或 pop() 操作）修改集合数据就抛出一个 java.util.ConcurrentModificationException 异常。
 * 解答：用一个计数器记录 push() 和 pop() 操作的次数。在创建迭代器时，将该值记录到
 * Iterator 的一个实例变量中。在每次调用 hasNext() 和 next() 之前，检查该值是否发生了变化，
 * 如果变化则抛出异常。
 */
public class Ex50<Item> implements Iterable<Item> {

    private Node<Item> first;

    private int N;

    private int pushPopCount;

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
        pushPopCount++;
    }

    public Item pop() {
        // 从栈顶删除元素
        Item res = first.item;
        first = first.next;
        N--;
        pushPopCount++;
        return res;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node<Item> current = first;

        private int originatedPushPopCount;

        public ListIterator() {
            this.originatedPushPopCount = pushPopCount;
        }

        @Override
        public boolean hasNext() {
            // 检测 current 是否为 null
            return current != null;
        }

        @Override
        public Item next() {
            if (originatedPushPopCount != pushPopCount) {
                throw new java.util.ConcurrentModificationException();
            }
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

    public static void main(String[] args) {
        Ex50<Integer> stack = new Ex50<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (Integer i : stack) {
            stack.pop();
        }
    }

}
