package io.github.kangjinghang.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * 把标准输入中的所有整数逆序排列
 * <p>
 * 100
 * 99
 * 101
 */
public class Reverse {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }
//        for (Integer i : stack) {
//            StdOut.println(i);
//        }
//        System.out.println();
        while (!stack.isEmpty()) {
            StdOut.println(stack.pop());
        }
    }

}
