package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.StdDraw;

public class VisualAccumulator {

    /**
     * 记录所有数据值之和
     */
    private double total;

    /**
     * 记录已经处理过的数据值的数量
     */
    private int N;

    public VisualAccumulator(int trials, double max) {
        // trials：需要绘出的点数
        StdDraw.setXscale(0, trials);
        // max：y坐标最大值
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, mean());
    }

    /**
     * 和除以数据数量即可得到平均值
     */
    public double mean() {
        return total / N;
    }

    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }


}
