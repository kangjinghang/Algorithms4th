package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 直方图。假设标准输入流中含有一系列 double 值。编写一段程序，从命令行接受一个整数 N 和
 * 两个 double 值 l 和 r。将 (l，r) 分为 N 段并使用 StdDraw 画出输入流中的值落入每段的数量的
 * 直方图。
 *
 * <p>
 * java-algs4 Ex32.java 3 1.0 10.0
 */
public class Ex32 {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            list.add(scanner.nextDouble());
        }

        int[] num = new int[N];
        // 分段中元素最多数量
        int max = 0;
        // 分作N段，每段 step
        double step = (r - l) / N;

        for (int i = 0; i < list.size(); i++) {
            // 输入流中数值
            double element = list.get(i);
            // 位于 (l，r) 之中
            if (element >= l && element <= r) {
                // 分作 N 段
                for (int j = 0; j < N; j++) {
                    if (element > l + step * j && element <= l + step * j + step) {
                        // 当前段 num + 1
                        num[j]++;
                        if (max < num[j]) {
                            max = num[j];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            double x = (1.0 * i + 0.5) / N;
            double y = num[i] / (max * 2.0);
            double rw = 0.4 / N;
            // 矩形中点
            StdDraw.filledRectangle(x, y, rw, y);
        }

    }

}
