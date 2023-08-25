package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 栈与队列。用有限个栈实现一个队列，保证每个队列操作（在最坏情况下）都只需要常数次的
 * 栈操作。 警告：非常难！
 *
 * <a href="https://blog.csdn.net/synapse7/article/details/18133787">CSDN 文章</a>
 */
public class Ex49_3<Item> {

    private Stack<Item> stack;

    private Stack<Item> temp;

    public Ex49_3() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && temp.isEmpty();
    }

    public int size() {
        return stack.size() + temp.size();
    }

    // 入队时，将元素压入s1。
    public void enqueue(Item item) {
        // 上一个动作是入队 enqueue，正常
        // 上一个动作是出队 dequeue，即 部分元素已经在 temp 里了，这里继续 push 到 stack 即可。
        stack.push(item);
    }

    // queue: 1 2 3
    // stack: 3 2 1
    // temp:  1 2 3
    // 出队时，判断s2是否为空，如不为空，则直接弹出顶元素；如为空，则将s1的元素逐个“倒入”s2，把最后一个元素弹出并出队。
    public Item dequeue() {
        if (!temp.isEmpty()) {
            // 说明上一个操作是 dequeue，连续出队
            return temp.pop();
        }

        // 到这里，说明上一个动作是入队 enqueue
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        return temp.pop();
    }

    public static void main(String[] args) {
        Ex49_3<Integer> q = new Ex49_3<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println("size:" + q.size());
        System.out.println("-----------");
        q.enqueue(4);
        q.enqueue(5);
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }

}
