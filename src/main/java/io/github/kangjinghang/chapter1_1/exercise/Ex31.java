package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * 随机连接。编写一段程序，从命令行接受一个整数 N 和 double 值 p（0 到 1 之间）作为参数，
 * 在一个圆上画出大小为 0.05 且间距相等的 N 个点，然后将每对点按照概率 p 用灰线连接。
 */
public class Ex31 {

    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        double p = StdIn.readDouble();
        if (p < 0 || p > 1) {
            System.err.println("p is not valid!");
            return;
        }
        Point[] points = new Point[N];
        double angle = 360.0 / N;
        // 圆的 (x,y) 和 半径
        StdDraw.circle(0.5, 0.5, 0.5);
        // 圆的边的宽度
        StdDraw.setPenRadius(0.05);

        for (int i = 0; i < N; i++) {
            // 计算点坐标
            points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
                    0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
            StdDraw.point(points[i].x, points[i].y);
        }

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(Color.RED);
        // [0,N-2]
        for (int i = 0; i < N - 1; i++) {
            // [j,N-1]
            for (int j = i + 1; j < N; j++) {
                // 计算概率
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
                }
            }
        }
    }


}
