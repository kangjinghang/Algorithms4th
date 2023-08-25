package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 文本编辑器的缓冲区。为文本编辑器的缓冲区设计一种数据类型并实现表 1.3.13 中的 API。
 * -----------------------------------------------------
 * Public class Buffer
 * -----------------------------------------------------
 * Buffer() 创建一块空缓冲区
 * void insert(char c) 在光标位置插入字符 c
 * char delete() 删除并返回光标位置的字符
 * void left(int k) 将光标向左移动 k 个位置
 * void right(int k) 将光标向右移动 k 个位置
 * int size() 缓冲区中的字符数量
 * -----------------------------------------------------
 * 提示：使用两个栈。
 * 这里我们使用两个栈来模拟缓冲区。
 * 向左/向右移动 = 从左/右栈弹出相应数量的元素并压入另外一个栈。
 * 插入/删除 = 左栈压入/弹出一个元素。
 * 字符数量 = 左栈数量 + 右栈数量。
 */
public class Buffer {

    private Stack<Character> left;

    private Stack<Character> right;

    public Buffer() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void insert(char c) {
        left.push(c);
    }

    public char delete() {
        return left.pop();
    }

    public void left(int k) {
        for (int i = 0; i < k; i++) {
            right.push(left.pop());
        }
    }

    public void right(int k) {
        for (int i = 0; i < k; i++) {
            left.push(right.pop());
        }
    }

    public int size() {
        return left.size() + right.size();
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        // abc
        for (Character character : left) {
            sb.insert(0, character);
        }
        sb.append('|');
        right.forEach(sb::append);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.insert('e');
        buffer.display();

        buffer.left(2);
        buffer.display();

        buffer.right(1);
        buffer.display();

        buffer.delete();
        buffer.display();
    }

}
