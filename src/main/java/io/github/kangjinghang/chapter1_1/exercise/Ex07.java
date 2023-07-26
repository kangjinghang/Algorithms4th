package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 分别给出以下代码段打印出的值：
 * a. double t = 9.0;
 * while (Math.abs(t - 9.0/t) > .001)
 * t = (9.0/t + t) / 2.0;
 * StdOut.printf("%.5f\n", t);
 * b. int sum = 0;
 * for (int i = 1; i < 1000; i++)
 * for (int j = 0; j < i; j++)
 * sum++;
 * StdOut.println(sum);
 * c. int sum = 0;
 * for (int i = 1; i < 1000; i *= 2)
 * for (int j = 0; j < 1000; j++)
 * sum++;
 * StdOut.println(sum);
 */
public class Ex07 {

    public static void main(String[] args) {
        a();
        b();
        c();
    }

    public static void a() {
        // t = 9.0 5.0 3.4 3.023529411764706 3.00009155413138
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    public static void b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        // (1 + 999) / 2 * 999 = 499500
        StdOut.println(sum);
    }

    public static void c() {
        int sum = 0;
        // 1 2 4 8 16 32 64 128 256 512（10个）
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++) // 1000
                sum++;
        // 10 * 1000 = 10000
        StdOut.println(sum);
    }

}
