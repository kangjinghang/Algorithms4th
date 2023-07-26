package io.github.kangjinghang.chapter1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * DrawApiTest
 */
public class DrawApiTest {

    public static void main(String[] args) {
//        drawFunction();
//        drawRandomArray();
        drawSortedRandomArray();
    }

    /**
     * 函数值
     */
    public static void drawFunction() {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    /**
     * 随机数组
     */
    public static void drawRandomArray() {
        // 数组长度
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            // 数组赋值
            a[i] = StdRandom.uniformDouble();
        }
        for (int i = 0; i < N; i++) {
            // 矩形 x 轴中点
            double x = 1.0D * i / N;
            // 矩形 y 轴中点
            double y = a[i] / 2.0D;
            // 矩形宽度的一半
            double rw = 0.5D / N;
            // 矩形长度的一半
            double rh = a[i] / 2.0D;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }


    /**
     * 已排序的随机数组
     */
    public static void drawSortedRandomArray() {
        // 数组长度
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            // 数组赋值
            a[i] = StdRandom.uniformDouble();
        }
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            // 矩形 x 轴中点
            double x = 1.0D * i / N;
            // 矩形 y 轴中点
            double y = a[i] / 2.0D;
            // 矩形宽度的一半
            double rw = 0.5D / N;
            // 矩形长度的一半
            double rh = a[i] / 2.0D;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

}
