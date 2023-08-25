package io.github.kangjinghang.chapter1_3.exercise;

import edu.princeton.cs.algs4.StdOut;
import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 当 N 为 50 时下面这段代码会打印什么？从较高的抽象层次描述给定正整数 N 时这段代码的行为。
 * Stack<Integer> stack = new Stack<Integer>();
 * while (N > 0)
 * {
 * stack.push(N % 2);
 * N = N / 2;
 * }
 * for (int d : stack) StdOut.print(d);
 * StdOut.println();
 * 答：打印 N 的二进制表示（当 N 为 50 时打印 110010）。
 */
public class Ex05 {

    public static void main(String[] args) {
        int N = 50;
        Stack<Integer> stack = new Stack<>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) {
            StdOut.print(d);
        }
        // 打印 N 的二进制表示（当 N 为 50 时打印 110010）
        StdOut.println();
    }

}
