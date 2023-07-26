package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 下面这段程序会打印出什么？
 * int f = 0;
 * int g = 1;
 * for (int i = 0; i <= 15; i++)
 * {
 * StdOut.println(f);
 * f = f + g;
 * g = f - g;
 * }
 */
public class Ex06 {

    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        // [0,15] 共16次循环
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            // a[i + 1] = a[i] + a[i-1]
            // f 是 a[i]
            // g 是 a[i-1]
            f = f + g;
            // 斐波那契数列
            // f: 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
            // g: 1 0 1 1 2 3 5 8  13 21 34 55  89 144 233 377
            // g = a[i] - a[i-2] = a[i-1]
            g = f - g;
        }
    }

}
