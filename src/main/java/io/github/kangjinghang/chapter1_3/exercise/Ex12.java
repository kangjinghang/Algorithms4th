package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 编写一个可迭代的 Stack 用例，它含有一个静态的 copy() 方法，接受一个字符串的栈作为参数
 * 并返回该栈的一个副本。 注意：这种能力是迭代器价值的一个重要体现，因为有了它我们无需
 * 改变基本 API 就能够实现这种功能。
 */
public class Ex12 {

    public static void main(String[] args) {
        Stack<String> s1 = new Stack<>();
        s1.push("first");
        s1.push("second");
        s1.push("third");

        Stack<String> s2 = Stack.copy(s1);
        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }

}
