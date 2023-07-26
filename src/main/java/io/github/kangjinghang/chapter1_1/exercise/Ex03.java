package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个程序，从命令行得到三个整数参数。如果它们都相等则打印 equal，否则打印 not equal。
 */
public class Ex03 {

    public static void main(String[] args) {
        // 控制台输入数字
        final int a = StdIn.readInt();
        // 控制台输入数字
        final int b = StdIn.readInt();
        // 控制台输入数字
        final int c = StdIn.readInt();
        if (a == b && b == c) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }

}
