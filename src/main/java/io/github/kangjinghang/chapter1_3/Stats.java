package io.github.kangjinghang.chapter1_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 简单地计算标准输入中的所有 double 值的平均值和样本标准差。如果标准输入中有 N
 * 个数字，那么平均值为它们的和除以 N，样本标准差为每个值和平均值之差的平方之和除以 N-1 之
 * 后的平方根。
 * <p>
 * 100
 * 99
 * 101
 * 120
 * 98
 * 107
 * 109
 * 81
 * 101
 * 90
 * ^D
 * Mean: 100.60
 * Std dev: 10.51
 */
public class Stats {

    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();
        double sum = 0.0D;
        for (Double number : numbers) {
            sum += number;
        }

        double mean = sum / N;

        sum = 0.0D;
        for (Double number : numbers) {
            sum += (number - mean) * (number - mean);
        }
        double std = Math.sqrt(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }

}
