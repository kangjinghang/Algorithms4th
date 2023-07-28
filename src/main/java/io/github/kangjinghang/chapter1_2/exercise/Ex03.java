package io.github.kangjinghang.chapter1_2.exercise;

import edu.princeton.cs.algs4.*;

/**
 * 编写一个 Interval2D 的用例，从命令行接受参数 N、min 和 max。生成 N 个随机的 2D 间隔，其宽
 * 和高均匀地分布在单位正方形中的 min 和 max 之间。用 StdDraw 画出它们并打印出相交的间隔对
 * 的数量以及有包含关系的间隔对数量。
 */
public class Ex03 {

    public static void main(String[] args) {
//        int N = Integer.parseInt(args[0]);
        int N = 10;
        double min = 0.1;
        double max = 0.9;
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        Interval2D[] intervals = new Interval2D[N];
        // 左上角顶点数组
        Point2D[] leftTopPoints = new Point2D[N];
        // 右下角顶点数组
        Point2D[] rightBottomPoints = new Point2D[N];

        for (int i = 0; i < N; i++) {
            double a = StdRandom.uniformDouble(min, max);
            double b = StdRandom.uniformDouble(min, max);
            double left = Math.min(a, b);
            double right = Math.max(a, b);
            final Interval1D x = new Interval1D(left, right);

            a = StdRandom.uniformDouble(min, max);
            b = StdRandom.uniformDouble(min, max);
            double bottom = Math.min(a, b);
            double top = Math.max(a, b);
            final Interval1D y = new Interval1D(bottom, top);

            // 左上角顶点
            leftTopPoints[i] = new Point2D(left, top);
            // 右下角顶点
            rightBottomPoints[i] = new Point2D(right, bottom);
            intervals[i] = new Interval2D(x, y);
            intervals[i].draw();
        }

        int containNum = 0, intervalNum = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                // i j 相交两次，只计一次数
                if (j > i && intervals[i].intersects(intervals[j])) {
                    // 相交关系
                    intervalNum++;
                }
                // intervals[i] 同时包含了左上顶点和右下顶点
                if (j != i && intervals[i].contains(leftTopPoints[j]) && intervals[i].contains(rightBottomPoints[j])) {
                    // 包含关系
                    containNum++;
                }
            }
        }

    }
}
