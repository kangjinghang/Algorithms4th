package io.github.kangjinghang.chapter1_2.exercise;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 编写一个 Interval1D 的用例，从命令行接受一个整数 N。从标准输入中读取 N 个间隔（每个间隔由一对 double 值定义）
 * 并打印出所有相交的间隔对。
 */
public class Ex02 {

    public static void main(String[] args) {
//        int N = Integer.parseInt(args[0]);
        int N = 5;
        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            final double a = StdRandom.uniformDouble();
            final double b = StdRandom.uniformDouble();
            intervals[i] = new Interval1D(Math.min(a, b), Math.max(a, b));
        }

        if (N > 1) {
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (intervals[i].intersects(intervals[j])) {
                        System.out.println(intervals[i] + " intersects " + intervals[j]);
                    }
                }
            }
        }

    }

}
