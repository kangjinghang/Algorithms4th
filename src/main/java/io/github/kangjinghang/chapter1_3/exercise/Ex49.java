package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 栈与队列。用有限个栈实现一个队列，保证每个队列操作（在最坏情况下）都只需要常数次的
 * 栈操作。 警告：非常难！
 *
 * <a href="https://blog.csdn.net/synapse7/article/details/18133787">CSDN 文章</a>
 */
public class Ex49<Item> {

    private Stack<Item> stack;

    private Stack<Item> temp;

    public Ex49() {
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
        stack.push(item);
    }

    // queue: 1 2 3
    // stack: 3 2 1
    // temp:  1 2 3
    public Item dequeue() {
        if (stack.size() == 1) {
            return stack.pop();
        }
        while (stack.size() > 1) {
            temp.push(stack.pop());
        }
        final Item result = stack.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        Ex49<Integer> q = new Ex49<>();
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
