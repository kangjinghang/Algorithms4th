package io.github.kangjinghang.chapter1_2;

/**
 * 能够为用例计算一组数据的实时平均值的抽象数据类型。
 */
public class MyAccumulator {

    /**
     * 记录所有数据值之和
     */
    private double total;

    /**
     * 记录已经处理过的数据值的数量
     */
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
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
