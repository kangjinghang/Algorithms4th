package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Queue;
import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 下面这段代码对队列 q 进行了什么操作？
 * Stack<String> stack = new Stack<String>();
 * while (!q.isEmpty())
 * stack.push(q.dequeue());
 * while (!stack.isEmpty())
 * q.enqueue(stack.pop());
 *
 * 最终，颠倒了 q 的顺序
 */
public class Ex06 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Queue<String> q = new Queue<>();
        while (!q.isEmpty()) {
            // 从 q 的队头取元素，然后依次入栈
            stack.push(q.dequeue());
        }
        while (!stack.isEmpty()) {
            // 出栈，然后依次入队尾
            q.enqueue(stack.pop());
        }
        // 颠倒 q 的顺序
    }

}
