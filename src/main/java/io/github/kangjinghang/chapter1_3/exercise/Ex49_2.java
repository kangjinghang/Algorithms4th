package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 栈与队列。用有限个栈实现一个队列，保证每个队列操作（在最坏情况下）都只需要常数次的
 * 栈操作。 警告：非常难！
 *
 * <a href="https://blog.csdn.net/synapse7/article/details/18133787">CSDN 文章</a>
 */
public class Ex49_2<Item> {

    private Stack<Item> stack;

    private Stack<Item> temp;

    public Ex49_2() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void enqueue(Item item) {
        if (stack.isEmpty()) {
            // 说明 stack 是空的，之前是 dequeue 操作，导致所有元素都在 temp 中
            transfer(temp, stack);
        }
        stack.push(item);
    }

    // queue: 1 2 3
    // stack: 3 2 1
    // temp:  1 2 3
    public Item dequeue() {
        if (!temp.isEmpty()) {
            // 说明之前是 dequeue 操作，导致所有元素都在 temp 中，继续 pop 即可
            return temp.pop();
        }
        // 到这，说明 temp 是空的
        transfer(stack, temp);
        final Item result = temp.pop();
        transfer(temp, stack);
        return result;
    }

    private void transfer(Stack<Item> src, Stack<Item> dst) {
        while (!src.isEmpty()) {
            dst.push(src.pop());
        }
    }

    public static void main(String[] args) {
        Ex49_2<Integer> q = new Ex49_2<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }

}
