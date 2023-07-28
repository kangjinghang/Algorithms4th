package io.github.kangjinghang.chapter1_2.exercise;

import edu.princeton.cs.algs4.StdIn;

/**
 * 累加器的方差。以下代码为 Accumulator 类添加了 var() 和 stddev() 方法，它们计算了
 * addDataValue() 方法的参数的方差和标准差，验证这段代码。
 * public class Accumulator
 * {
 * private double m;
 * private double s;
 * private int N;
 * public void addDataValue(double x)
 * {
 * N++;
 * s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
 * m = m + (x - m) / N;
 * }
 * public double mean()
 * { return m; }
 * public double var()
 * { return s/(N - 1); }
 * public double stddev()
 * { return Math.sqrt(this.var()); }
 * }
 * 与直接对所有数据的平方求和的方法相比较，这种实现能够更好地避免四舍五入产生的误差。
 */
public class Ex18 {

    public static class Accumulator {

        /**
         * 平均数
         */
        private double m;

        /**
         * 方差
         */
        private double s;

        private int N;

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        /**
         * 标准差
         */
        public double stddev() {
            return Math.sqrt(this.var());
        }
    }

    public static void main(String[] args) {
        Ex18.Accumulator accumulator = new Ex18.Accumulator();
        while (!StdIn.isEmpty()) {
            accumulator.addDataValue(StdIn.readDouble());
        }
        System.out.println("Mean: " + accumulator.mean());
        System.out.println("Var: " + accumulator.var());
        System.out.println("Stddev: " + accumulator.stddev());
    }


}
