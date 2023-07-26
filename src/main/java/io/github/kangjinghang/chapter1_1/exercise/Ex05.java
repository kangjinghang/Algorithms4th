package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一段程序，如果 double 类型的变量 x 和 y 都严格位于 0 和 1 之间则打印 true，否则打印 false。
 */
public class Ex05 {

    public static void main(String[] args) {
        // 控制台输入数字
        final double x = StdIn.readDouble();
        // 控制台输入数字
        final double y = StdIn.readDouble();
        if (x > 0 && x < 1 && y > 0 && y < 1) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
        }
    }

}
