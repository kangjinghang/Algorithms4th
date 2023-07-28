package io.github.kangjinghang.chapter1_2.exercise;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 编写一个 Point2D 的用例，从命令行接受一个整数 N。在单位正方形中生成 N 个随机点，然后计算两点之间的最近距离。
 */
public class Ex01 {

    public static void main(String[] args) {
//        int N = Integer.parseInt(args[0]);
        int N = 1000;
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(StdRandom.uniformDouble(), StdRandom.uniformDouble());
            points[i].draw();
        }

        if (N >= 2) {
            double min = points[0].distanceTo(points[1]);
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (min > points[i].distanceTo(points[j])) {
                        min = points[i].distanceTo(points[j]);
                    }
                }
            }
            System.out.println("Min distance: " + min);
        }

    }

}
