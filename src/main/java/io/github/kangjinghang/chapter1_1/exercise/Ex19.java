package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 在计算机上运行以下程序：
 * public class Fibonacci
 * {
 * public static long F(int N)
 * {
 * if (N == 0) return 0;
 * if (N == 1) return 1;
 * return F(N-1) + F(N-2);
 * }
 * public static void main(String[] args)
 * {
 * for (int N = 0; N < 100; N++)
 * StdOut.println(N + " " + F(N));
 * }
 * }
 * 计算机用这段程序在一个小时之内能够得到 F(N) 结果的最大 N 值是多少？开发 F(N) 的一
 * 个更好的实现，用数组保存已经计算过的值。
 */
public class Ex19 {

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long[] F2(int N) {
        long[] fibonacci = new long[N + 1];
        if (N == 0) {
            return fibonacci;
        }
        fibonacci[1] = 1;
        if (N == 1) {
            // {0,1}
            return fibonacci;
        }
        for (int i = 2; i <= N; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }

    public static void main(String[] args) {
//        for (int N = 0; N < 100; N++) {
//            StdOut.println(N + " " + F(N));
//        }

        long[] fibonacci = F2(99);
        for (int N = 0; N < fibonacci.length; N++) {
            StdOut.println(N + " " + fibonacci[N]);
        }
    }

}
